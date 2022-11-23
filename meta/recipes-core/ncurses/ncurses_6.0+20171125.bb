require ncurses.inc
PR .= ".3"
SRC_URI += "file://0001-tic-hang.patch \
            file://0002-configure-reproducible.patch \
            file://config.cache \
            file://CVE-2018-10754.patch \
            file://CVE-2019-17594-and-CVE-2019-17595.patch \
            file://0001-CVE-2021-39537.patch \
            file://CVE-2022-29458.patch \
"
# commit id corresponds to the revision in package version
SRCREV = "5d849e836052459901cfe0b85a0b2939ff8d2b2a"
S = "${WORKDIR}/git"
EXTRA_OECONF += "--with-abi-version=5"
UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>\d+(\.\d+)+(\+\d+)*)"
