require ncurses.inc

SRC_URI += "file://0001-tic-hang.patch \
            file://0002-configure-reproducible.patch \
            file://config.cache \
            file://CVE-2019-17594-and-CVE-2019-17595.patch \
            file://CVE-2021-39537.patch \
"

PR .= ".1"

# commit id corresponds to the revision in package version
SRCREV = "d3b29180ae4360d7ab7a41a15e963299fdb72e33"
S = "${WORKDIR}/git"
EXTRA_OECONF += "--with-abi-version=5"
UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>\d+(\.\d+)+(\+\d+)*)"
