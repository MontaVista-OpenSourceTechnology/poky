require ruby.inc

SRC_URI += " \
           file://ruby-CVE-2017-9224.patch \
           file://ruby-CVE-2017-9226.patch \
           file://ruby-CVE-2017-9227.patch \
           file://ruby-CVE-2017-9228.patch \
           file://ruby-CVE-2017-9229.patch \
           file://ruby-CVE-2018-16395.patch \
           file://CVE-2018-16396.patch \
           file://CVE-2019-15845.patch \
           file://CVE-2019-16254.patch \
           file://CVE-2019-16255.patch \
           file://CVE-2020-10663.patch \
	   file://CVE-2020-25613.patch \
	   file://0001-CVE-2021-31799.patch \
	   file://0001-CVE-2021-32066.patch \
	   file://0001-CVE-2021-31810.patch \
	   file://0001-CVE-2021-28965.patch \
	   file://0001-CVE-2021-41817.patch \
	   file://0001-CVE-2021-41819.patch \
	   file://0001-CVE-2019-8321-to-CVE-2019-8325.patch \
           file://0001-CVE-2022-28739.patch \
           file://CVE-2023-28756.patch \
           file://CVE-2021-33621-1.patch \
           file://CVE-2021-33621-2-pre1.patch \
           file://CVE-2021-33621-2-pre2.patch \
           file://CVE-2021-33621-2.patch \
           "

PR = "r9.5"

SRC_URI[md5sum] = "d50e00ccc1c9cf450f837b92d3ed3e88"
SRC_URI[sha256sum] = "254f1c1a79e4cc814d1e7320bc5bdd995dc57e08727d30a767664619a9c8ae5a"

# it's unknown to configure script, but then passed to extconf.rb
# maybe it's not really needed as we're hardcoding the result with
# 0001-socket-extconf-hardcode-wide-getaddr-info-test-outco.patch
UNKNOWN_CONFIGURE_WHITELIST += "--enable-wide-getaddrinfo"

PACKAGECONFIG ??= ""
PACKAGECONFIG += "${@bb.utils.filter('DISTRO_FEATURES', 'ipv6', d)}"

PACKAGECONFIG[valgrind] = "--with-valgrind=yes, --with-valgrind=no, valgrind"
PACKAGECONFIG[gmp] = "--with-gmp=yes, --with-gmp=no, gmp"
PACKAGECONFIG[ipv6] = ",--enable-wide-getaddrinfo,"

EXTRA_AUTORECONF += "--exclude=aclocal"

EXTRA_OECONF = "\
    --disable-versioned-paths \
    --disable-rpath \
    --disable-dtrace \
    --enable-shared \
    --enable-load-relative \
"

do_install() {
    oe_runmake 'DESTDIR=${D}' install
}

PACKAGES =+ "${PN}-ri-docs ${PN}-rdoc"

SUMMARY_${PN}-ri-docs = "ri (Ruby Interactive) documentation for the Ruby standard library"
RDEPENDS_${PN}-ri-docs = "${PN}"
FILES_${PN}-ri-docs += "${datadir}/ri"

SUMMARY_${PN}-rdoc = "RDoc documentation generator from Ruby source"
RDEPENDS_${PN}-rdoc = "${PN}"
FILES_${PN}-rdoc += "${libdir}/ruby/*/rdoc ${bindir}/rdoc"

FILES_${PN} += "${datadir}/rubygems"

BBCLASSEXTEND = "native"