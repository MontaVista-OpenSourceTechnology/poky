require recipes-devtools/rust/rust-source.inc
require recipes-devtools/rust/rust-snapshot.inc
require cargo.inc
BBCLASSEXTEND = "native nativesdk"

PR .= ".1"

SRC_URI += " \
	    file://CVE-2026-5222.patch \
	    file://CVE-2026-5223.patch \
	   "
