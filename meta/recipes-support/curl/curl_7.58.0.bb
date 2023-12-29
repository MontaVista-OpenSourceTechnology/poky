SUMMARY = "Command line tool and library for client-side URL transfers"
HOMEPAGE = "http://curl.haxx.se/"
BUGTRACKER = "http://curl.haxx.se/mail/list.cgi?list=curl-tracker"
SECTION = "console/network"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;beginline=8;md5=3a34942f4ae3fbf1a303160714e664ac"

PR = "r25"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2 \
           file://0001-replace-krb5-config-with-pkg-config.patch \
           file://CVE-2018-1000300.patch \
           file://CVE-2018-1000301.patch \
           file://CVE-2018-0500.patch \
           file://CVE-2018-14618-1.patch \
           file://CVE-2018-14618-2.patch \
           file://CVE-2018-16839.patch \
           file://CVE-2018-16890.patch \
           file://CVE-2019-3822.patch \
           file://CVE-2019-3823.patch \
           file://CVE-2018-16840.patch \
           file://CVE-2018-16842.patch \
           file://CVE-2019-5436.patch \
           file://CVE-2019-5481.patch \
           file://CVE-2019-5482.patch \
	   file://CVE-2021-22876_p1.patch \
	   file://CVE-2021-22876_p2.patch \
	   file://CVE-2020-8177.patch \
	   file://CVE-2020-8231.patch \
	   file://CVE-2020-8285.patch \
	   file://CVE-2020-8286.patch \
	   file://CVE-2021-22924.patch \
	   file://CVE-2021-22946_p1.patch \
	   file://CVE-2021-22946_p2.patch \
	   file://CVE-2021-22947.patch \
           file://0001-CVE-2022-22576_p1.patch \
           file://0001-CVE-2022-22576_p2.patch \
           file://0001-CVE-2022-27776.patch \
           file://0001-CVE-2022-27774_p1.patch \
           file://0001-CVE-2022-27774_p2.patch \
           file://0001-CVE-2022-27774_p3.patch \
           file://0001-CVE-2022-27782_p1.patch \
           file://0001-CVE-2022-27782_p2.patch \
           file://CVE-2022-27781.patch \
           file://0001-CVE-2022-32208.patch \
           file://0001-CVE-2022-32206.patch \
           file://0001-CVE-2022-35252.patch \
           file://CVE-2022-32221.patch \
           file://CVE-2021-22925.patch \
           file://CVE-2022-43552.patch \
           file://CVE-2023-27533.patch \
           file://CVE-2023-27534-pre1.patch \
           file://CVE-2023-27534.patch \
           file://CVE-2023-27538-pre1.patch \
           file://CVE-2023-27538.patch \
           file://CVE-2023-27536.patch \
           file://CVE-2023-27535.patch \
           file://CVE-2023-28320-pre1.patch \
           file://CVE-2023-28320-1.patch \
           file://CVE-2023-28320-2.patch \
           file://CVE-2023-28321.patch \
           file://CVE-2023-28322.patch \
           file://CVE-2023-46218-pre1.patch \
           file://CVE-2023-46218-pre2.patch \
           file://CVE-2023-46218-pre3.patch \
           file://CVE-2023-46218-pre4.patch \
           file://CVE-2023-46218.patch \
"


# curl likes to set -g0 in CFLAGS, so we stop it
# from mucking around with debug options
#
SRC_URI += " file://configure_ac.patch"

SRC_URI[md5sum] = "fa049f9f90c1ae473a2a7bcfa14de976"
SRC_URI[sha256sum] = "1cb081f97807c01e3ed747b6e1c9fee7a01cb10048f1cd0b5f56cfe0209de731"

CVE_PRODUCT = "libcurl"
inherit autotools pkgconfig binconfig multilib_header

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'ipv6', d)} gnutls proxy threaded-resolver zlib"
PACKAGECONFIG_class-native = "ipv6 proxy ssl threaded-resolver zlib"
PACKAGECONFIG_class-nativesdk = "ipv6 proxy ssl threaded-resolver zlib"

# 'ares' and 'threaded-resolver' are mutually exclusive
PACKAGECONFIG[ares] = "--enable-ares,--disable-ares,c-ares"
PACKAGECONFIG[dict] = "--enable-dict,--disable-dict,"
PACKAGECONFIG[gnutls] = "--with-gnutls,--without-gnutls,gnutls"
PACKAGECONFIG[gopher] = "--enable-gopher,--disable-gopher,"
PACKAGECONFIG[imap] = "--enable-imap,--disable-imap,"
PACKAGECONFIG[ipv6] = "--enable-ipv6,--disable-ipv6,"
PACKAGECONFIG[ldap] = "--enable-ldap,--disable-ldap,"
PACKAGECONFIG[ldaps] = "--enable-ldaps,--disable-ldaps,"
PACKAGECONFIG[libidn] = "--with-libidn2,--without-libidn2,libidn2"
PACKAGECONFIG[libssh2] = "--with-libssh2,--without-libssh2,libssh2"
PACKAGECONFIG[pop3] = "--enable-pop3,--disable-pop3,"
PACKAGECONFIG[proxy] = "--enable-proxy,--disable-proxy,"
PACKAGECONFIG[rtmpdump] = "--with-librtmp,--without-librtmp,rtmpdump"
PACKAGECONFIG[rtsp] = "--enable-rtsp,--disable-rtsp,"
PACKAGECONFIG[smb] = "--enable-smb,--disable-smb,"
PACKAGECONFIG[smtp] = "--enable-smtp,--disable-smtp,"
PACKAGECONFIG[ssl] = "--with-ssl --with-random=/dev/urandom,--without-ssl,openssl"
PACKAGECONFIG[telnet] = "--enable-telnet,--disable-telnet,"
PACKAGECONFIG[tftp] = "--enable-tftp,--disable-tftp,"
PACKAGECONFIG[threaded-resolver] = "--enable-threaded-resolver,--disable-threaded-resolver"
PACKAGECONFIG[zlib] = "--with-zlib=${STAGING_LIBDIR}/../,--without-zlib,zlib"
PACKAGECONFIG[krb5] = "--with-gssapi,--without-gssapi,krb5"
PACKAGECONFIG[nghttp2] = "--with-nghttp2,--without-nghttp2,nghttp2"

EXTRA_OECONF = " \
    --enable-crypto-auth \
    --with-ca-bundle=${sysconfdir}/ssl/certs/ca-certificates.crt \
    --without-libmetalink \
    --without-libpsl \
"


do_install_append_class-target() {
	# cleanup buildpaths from curl-config
	sed -i \
	    -e 's,--sysroot=${STAGING_DIR_TARGET},,g' \
	    -e 's,--with-libtool-sysroot=${STAGING_DIR_TARGET},,g' \
	    -e 's|${DEBUG_PREFIX_MAP}||g' \
	    ${D}${bindir}/curl-config
}

PACKAGES =+ "lib${BPN}"

FILES_lib${BPN} = "${libdir}/lib*.so.*"
RRECOMMENDS_lib${BPN} += "ca-certificates"

FILES_${PN} += "${datadir}/zsh"

BBCLASSEXTEND = "native nativesdk"
