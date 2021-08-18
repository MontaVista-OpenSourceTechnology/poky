SUMMARY = "Provide limited super user privileges to specific users"
DESCRIPTION = "Sudo (superuser do) allows a system administrator to give certain users (or groups of users) the ability to run some (or all) commands as root while logging all commands and arguments."
HOMEPAGE = "http://www.sudo.ws"
BUGTRACKER = "http://www.sudo.ws/bugs/"
SECTION = "admin"
LICENSE = "ISC & BSD & Zlib"
LIC_FILES_CHKSUM = "file://doc/LICENSE;md5=07966675feaddba70cc812895b248230 \
                    file://plugins/sudoers/redblack.c;beginline=1;endline=41;md5=31c82350e79cab3b62235c42d4a5fed5 \
                    file://lib/util/reallocarray.c;beginline=3;endline=16;md5=6b7f9e2ab2815d32dcbf4218241ba5fa \
                    file://lib/util/fnmatch.c;beginline=3;endline=27;md5=004d7d2866ba1f5b41174906849d2e0f \
                    file://lib/util/getcwd.c;beginline=5;endline=27;md5=9805c43187b7d4735d9df89e8b6359d1 \
                    file://lib/util/glob.c;beginline=6;endline=31;md5=54994e5b5239e2663d2e345ed867d6a2 \
                    file://lib/util/snprintf.c;beginline=6;endline=34;md5=bdbaa980a4169d1ed9df5dab55bb65c4 \
                    file://include/sudo_queue.h;beginline=5;endline=27;md5=9805c43187b7d4735d9df89e8b6359d1 \
                    file://lib/util/inet_pton.c;beginline=3;endline=17;md5=27785c9f5835093eda42aa0816a2d0b4"

inherit autotools

PACKAGECONFIG ??= ""
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib"

CONFFILES_${PN} = "${sysconfdir}/sudoers"

EXTRA_OECONF = "--with-editor=${base_bindir}/vi --with-env-editor"

EXTRA_OECONF_append_libc-musl = " --disable-hardening "

# mksigname/mksiglist are used on build host to generate source files
do_compile_prepend () {
	# Remove build host references from sudo_usage.h
	sed -i  \
	    -e 's,--with-libtool-sysroot=${STAGING_DIR_TARGET},,g' \
	    -e 's,--build=${BUILD_SYS},,g' \
	    -e 's,--host=${HOST_SYS},,g' \
	    ${B}/src/sudo_usage.h
	oe_runmake SSP_CFLAGS="" SSP_LDFLAGS="" CC="$BUILD_CC" CFLAGS="$BUILD_CFLAGS" CPPFLAGS="$BUILD_CPPFLAGS -I${S}/include -I${S} -I${B}"  -C lib/util mksigname mksiglist
}

# Explicitly create ${localstatedir}/lib before do_install to ensure
# the directory is accessible by all users. Otherwise the mkinstalldirs
# script (from sudo) will recursively create ${localstatedir}/lib/sudo
# and then chmod each directory with 0700 permissions, which isn't what
# we want (i.e, users would not be able to access /var/lib).
do_install_prepend (){
	mkdir -p ${D}/${localstatedir}/lib
}
