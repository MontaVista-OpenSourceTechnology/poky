SUMMARY = "GRUB2 is the next-generation GRand Unified Bootloader"

DESCRIPTION = "GRUB2 is the next generaion of a GPLed bootloader \
intended to unify bootloading across x86 operating systems. In \
addition to loading the Linux kernel, it implements the Multiboot \
standard, which allows for flexible loading of multiple boot images."

HOMEPAGE = "http://www.gnu.org/software/grub/"
SECTION = "bootloaders"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

PR .= ".7"

SRC_URI = "https://ftp.gnu.org/gnu/grub/grub-${PV}.tar.gz \
           file://0001-Disable-mfpmath-sse-as-well-when-SSE-is-disabled.patch \
           file://0001-Unset-need_charset_alias-when-building-for-musl.patch \
           file://autogen.sh-exclude-pc.patch \
           file://grub-module-explicitly-keeps-symbole-.module_license.patch \
           file://0001-grub.d-10_linux.in-add-oe-s-kernel-name.patch \
	   file://fix.build.with.gcc-7.patch \
	   file://CVE-2020-10713.patch \
	   file://CVE-2020-15706.patch \
	   file://CVE-2020-14372_dep1.patch \
	   file://CVE-2020-14372.patch \
	   file://CVE-2020-25632.patch \
	   file://CVE-2020-25647.patch \
	   file://CVE-2020-27779.patch \
	   file://CVE-2021-20233.patch \
	   file://CVE-2021-20225.patch \
	   file://CVE-2021-3695.patch \
	   file://CVE-2021-3696.patch \
	   file://CVE-2021-3697-1.patch \
	   file://CVE-2021-3697-2.patch \
	   file://CVE-2022-28734.patch \
	   file://CVE-2022-28736.patch \
           file://0001-CVE-2020-15707.patch \
           file://0001-CVE-2022-28733.patch \
	   file://CVE-2020-14309-CVE-2020-14310-CVE-2020-14311.patch \
"
SRC_URI[md5sum] = "1116d1f60c840e6dbd67abbc99acb45d"
SRC_URI[sha256sum] = "660ee136fbcee08858516ed4de2ad87068bfe1b6b8b37896ce3529ff054a726d"

DEPENDS = "flex-native bison-native"

COMPATIBLE_HOST = '(x86_64.*|i.86.*|arm.*|aarch64.*)-(linux.*|freebsd.*)'
COMPATIBLE_HOST_armv7a = 'null'
COMPATIBLE_HOST_armv7ve = 'null'

# configure.ac has code to set this automagically from the target tuple
# but the OE freeform one (core2-foo-bar-linux) don't work with that.

GRUBPLATFORM_arm = "uboot"
GRUBPLATFORM_aarch64 = "efi"
GRUBPLATFORM ??= "pc"

inherit autotools gettext texinfo

EXTRA_OECONF = "--with-platform=${GRUBPLATFORM} \
                --disable-grub-mkfont \
                --program-prefix="" \
                --enable-liblzma=no \
                --enable-libzfs=no \
                --enable-largefile \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[grub-mount] = "--enable-grub-mount,--disable-grub-mount,fuse"
PACKAGECONFIG[device-mapper] = "--enable-device-mapper,--disable-device-mapper,lvm2"

# grub2 creates its own set of -nostdinc / -isystem / -ffreestanding CFLAGS and
# OE's default BUILD_CFLAGS (assigned to CFLAGS for native builds) etc, conflict
# with that. Note that since BUILD_CFLAGS etc are not used by grub2 target
# builds, it's safe to clear them unconditionally for both target and native.
BUILD_CPPFLAGS = ""
BUILD_CFLAGS = ""
BUILD_CXXFLAGS = ""
BUILD_LDFLAGS = ""

do_configure_prepend() {
	# The grub2 configure script uses variables such as TARGET_CFLAGS etc
	# for its own purposes. Remove the OE versions from the environment to
	# avoid conflicts.
	unset TARGET_CPPFLAGS TARGET_CFLAGS TARGET_CXXFLAGS TARGET_LDFLAGS
	( cd ${S}
	${S}/autogen.sh )
}

RDEPENDS_${PN}_class-native = ""
