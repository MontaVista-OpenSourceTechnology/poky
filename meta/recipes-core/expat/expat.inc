SUMMARY = "A stream-oriented XML parser library"
DESCRIPTION = "Expat is an XML parser library written in C. It is a stream-oriented parser in which an application registers handlers for things the parser might find in the XML document (like start tags)"
HOMEPAGE = "http://expat.sourceforge.net/"
SECTION = "libs"
LICENSE = "MIT"

PR = "r2.8"

SRC_URI = "${SOURCEFORGE_MIRROR}/expat/expat-${PV}.tar.bz2 \
           file://autotools.patch \
           file://libtool-tag.patch \
           file://CVE-2018-20843.patch \
	   file://CVE-2019-15903.patch \
           file://0001-CVE-2022-23990.patch \
	   file://0001-CVE-2021-45960.patch \
	   file://0001-CVE-2021-46143.patch \
	   file://0001-CVE-2022-22822-to-CVE-2022-22827.patch \
	   file://0001-CVE-2022-23852.patch \
	   file://0001-CVE-2022-25235.patch \
	   file://0001-CVE-2022-25236.patch \
	   file://0001-CVE-2022-25314.patch \
           file://0001-CVE-2022-25313.patch \
           file://0001-CVE-2022-25315.patch \
	  "

SRC_URI[md5sum] = "789e297f547980fc9ecc036f9a070d49"
SRC_URI[sha256sum] = "d9dc32efba7e74f788fcc4f212a43216fc37cf5f23f4c2339664d473353aedf6"

inherit autotools lib_package

# This package uses an archive format known to have issue with some
# versions of gzip
DEPENDS += "pigz-native"
do_unpack[depends] += "pigz-native:do_populate_sysroot"

do_configure_prepend () {
	rm -f ${S}/conftools/libtool.m4
}

BBCLASSEXTEND = "native nativesdk"
