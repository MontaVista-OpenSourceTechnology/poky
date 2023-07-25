SUMMARY = "Provides support for the Tag Image File Format (TIFF)"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=34da3db46fab7501992f9615d7e158cf"

CVE_PRODUCT = "libtiff"

SRC_URI = "http://download.osgeo.org/libtiff/tiff-${PV}.tar.gz \
           file://libtool2.patch \
           file://CVE-2017-9147.patch \
           file://CVE-2017-9936.patch \
           file://CVE-2017-10688.patch \
           file://CVE-2017-11335.patch \
           file://CVE-2017-13726.patch \
           file://CVE-2017-13727.patch \
           file://CVE-2018-12900.patch \
           file://CVE-2017-9935.patch \
           file://CVE-2017-18013.patch \
           file://CVE-2018-5784.patch \
           file://CVE-2018-10963.patch \
           file://CVE-2018-8905.patch \
           file://CVE-2018-7456.patch \
           file://CVE-2017-17095.patch \
           file://CVE-2018-17100.patch \		
           file://CVE-2017-16232.patch \
           file://CVE-2018-18661.patch \
           file://CVE-2018-19210_p1.patch \
           file://CVE-2018-19210_p2.patch \
           file://CVE-2018-17000.patch \
           file://0001-CVE-2022-0891-CVE-2022-1056.patch \
	   file://CVE-2022-0908.patch \
           file://CVE-2022-0562.patch \
	   file://CVE-2022-0909.patch \
	   file://CVE-2022-0907.patch \
           file://CVE-2022-0924.patch \
           file://0001-change-in-unit16_t-to-fix-compilation-error.patch \
           file://0001-CVE-2022-0865.patch \
           file://0001-CVE-2022-2056_to_CVE-2022-2058.patch \
           file://CVE-2018-18557.patch \
           file://0001-CVE-2019-14973.patch \
           file://0001-CVE-2022-0561.patch \
           file://0001-CVE-2022-34526.patch \
	   file://CVE-2022-1355.patch \
	   file://CVE-2022-22844.patch \
	   file://CVE-2022-2867_2868_2869.patch \
	   file://CVE-2022-3570_3598.patch \
	   file://CVE-2022-3599-CVE-2023-30086.patch \
	   file://CVE-2022-3970.patch \
	   file://CVE-2023-0795_0796_0797_0798_0799.patch \
	   file://CVE-2023-0800_0801_0802_0803_0804.patch \
          "

SRC_URI[md5sum] = "2a7d1c1318416ddf36d5f6fa4600069b"
SRC_URI[sha256sum] = "59d7a5a8ccd92059913f246877db95a2918e6c04fb9d43fd74e5c3390dac2910"

# exclude betas
UPSTREAM_CHECK_REGEX = "tiff-(?P<pver>\d+(\.\d+)+).tar"

PR = "r1.19"

inherit autotools multilib_header

CACHED_CONFIGUREVARS = "ax_cv_check_gl_libgl=no"

PACKAGECONFIG ?= "cxx jpeg zlib lzma \
                  strip-chopping extrasample-as-alpha check-ycbcr-subsampling"

PACKAGECONFIG[cxx] = "--enable-cxx,--disable-cxx,,"
PACKAGECONFIG[jpeg] = "--enable-jpeg,--disable-jpeg,jpeg,"
PACKAGECONFIG[zlib] = "--enable-zlib,--disable-zlib,zlib,"
PACKAGECONFIG[lzma] = "--enable-lzma,--disable-lzma,xz,"

# Convert single-strip uncompressed images to multiple strips of specified
# size (default: 8192) to reduce memory usage
PACKAGECONFIG[strip-chopping] = "--enable-strip-chopping,--disable-strip-chopping,,"

# Treat a fourth sample with no EXTRASAMPLE_ value as being ASSOCALPHA
PACKAGECONFIG[extrasample-as-alpha] = "--enable-extrasample-as-alpha,--disable-extrasample-as-alpha,,"

# Control picking up YCbCr subsample info. Disable to support files lacking
# the tag
PACKAGECONFIG[check-ycbcr-subsampling] = "--enable-check-ycbcr-subsampling,--disable-check-ycbcr-subsampling,,"

# Support a mechanism allowing reading large strips (usually one strip files)
# in chunks when using TIFFReadScanline. Experimental 4.0+ feature
PACKAGECONFIG[chunky-strip-read] = "--enable-chunky-strip-read,--disable-chunky-strip-read,,"

PACKAGES =+ "tiffxx tiff-utils"
FILES_tiffxx = "${libdir}/libtiffxx.so.*"
FILES_tiff-utils = "${bindir}/*"

do_install_append() {
    oe_multilib_header tiffconf.h
}

BBCLASSEXTEND = "native"
