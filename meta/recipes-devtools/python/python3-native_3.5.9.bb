require recipes-devtools/python/python.inc

PR = "${INC_PR}.0"
PYTHON_MAJMIN = "3.5"
DISTRO_SRC_URI ?= "file://sitecustomize.py"
DISTRO_SRC_URI_linuxstdbase = ""
SRC_URI = "http://www.python.org/ftp/python/${PV}/Python-${PV}.tar.xz \
file://12-distutils-prefix-is-inside-staging-area.patch \
file://python-config.patch \
file://0001-cross-compile-support.patch \
file://030-fixup-include-dirs.patch \
file://070-dont-clean-ipkg-install.patch \
file://080-distutils-dont_adjust_files.patch \
file://130-readline-setup.patch \
file://150-fix-setupterm.patch \
file://python-3.3-multilib.patch \
file://03-fix-tkinter-detection.patch \
file://avoid_warning_about_tkinter.patch \
file://shutil-follow-symlink-fix.patch \
file://0001-h2py-Fix-issue-13032-where-it-fails-with-UnicodeDeco.patch \
file://sysroot-include-headers.patch \
file://unixccompiler.patch \
${DISTRO_SRC_URI} \
file://sysconfig.py-add-_PYTHON_PROJECT_SRC.patch \
file://setup.py-check-cross_compiling-when-get-FLAGS.patch \
file://0001-Do-not-use-the-shell-version-of-python-config-that-w.patch \
file://support_SOURCE_DATE_EPOCH_in_py_compile.patch \
"

SRC_URI[md5sum] = "ef7f82485e83c7f8f8bcb920a9c2457b"
SRC_URI[sha256sum] = "c24a37c63a67f53bdd09c5f287b5cff8e8b98f857bf348c577d454d3f74db049"

LIC_FILES_CHKSUM = "file://LICENSE;md5=c07d26ca754e4aaef307411f8c604a79"

# exclude pre-releases for both python 2.x and 3.x
UPSTREAM_CHECK_REGEX = "[Pp]ython-(?P<pver>\d+(\.\d+)+).tar"

S = "${WORKDIR}/Python-${PV}"

EXTRANATIVEPATH += "bzip2-native"
DEPENDS = "openssl-native bzip2-replacement-native zlib-native readline-native sqlite3-native"

inherit native

require python-native-${PYTHON_MAJMIN}-manifest.inc

# uninative may be used on pre glibc 2.25 systems which don't have getentropy
EXTRA_OECONF_append = " --bindir=${bindir}/${PN} --without-ensurepip"

EXTRA_OEMAKE = '\
  LIBC="" \
  STAGING_LIBDIR=${STAGING_LIBDIR_NATIVE} \
  STAGING_INCDIR=${STAGING_INCDIR_NATIVE} \
  LIB=${baselib} \
  ARCH=${TARGET_ARCH} \
'

# No ctypes option for python 3
PYTHONLSBOPTS = ""

do_configure_append() {
	autoreconf --verbose --install --force --exclude=autopoint ../Python-${PV}/Modules/_ctypes/libffi
	sed -i -e 's,#define HAVE_GETRANDOM 1,/\* #undef HAVE_GETRANDOM \*/,' ${B}/pyconfig.h
}

# Regenerate all of the generated files
# This ensures that pgen and friends get created during the compile phase
do_compile_prepend() {
    oe_runmake regen-all
}

do_install() {
	install -d ${D}${libdir}/pkgconfig
	oe_runmake 'DESTDIR=${D}' install
	if [ -e ${WORKDIR}/sitecustomize.py ]; then
		install -m 0644 ${WORKDIR}/sitecustomize.py ${D}/${libdir}/python${PYTHON_MAJMIN}
	fi
	install -d ${D}${bindir}/${PN}
	install -m 0755 Parser/pgen ${D}${bindir}/${PN}

	# Make sure we use /usr/bin/env python
	for PYTHSCRIPT in `grep -rIl ${bindir}/${PN}/python ${D}${bindir}/${PN}`; do
		sed -i -e '1s|^#!.*|#!/usr/bin/env python3|' $PYTHSCRIPT
	done

	# Tests are large and we don't need them in the native sysroot
	rm ${D}${libdir}/python${PYTHON_MAJMIN}/test -rf
}

RPROVIDES += "python3-misc-native"