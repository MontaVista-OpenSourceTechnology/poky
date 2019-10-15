require sysstat.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a23a74b3f4caf9616230789d94217acb"

PR .= ".11"

SRC_URI += "file://0001-Include-needed-headers-explicitly.patch \
	    file://0001-sar-Fortify-remap_struct-function.patch \
	    file://0002-Remove-int-in-bool-context-warnings.patch \
	    file://0003-Remove-some-format-truncation-warnings.patch \
	    file://0004-sar.c-Fix-gcc-warning-about-possible-variables-overl.patch \
	    file://0005-Use-memcpy-rather-than-strncpy-in-order-to-avoid-tru.patch \
	    file://0006-sar-Update-remap_struct-function-prototype.patch \
	    file://0007-sadf-Make-it-more-robust-to-corrupted-datafiles.patch \
	    file://0008-Fix-196-and-199-Out-of-bound-reads-security-issues.patch \
	    file://0009-Remove-remap_struct-prototype-from-sa.h.patch \
	    file://0010-Fix-230-Memory-corruption-bug-due-to-Integer-Overflo.patch \
	    file://0011-Add-a-return-code-to-remap_struct-function.patch \
"

SRC_URI[md5sum] = "421f958db80e67a27eda1ff6b8ebcdeb"
SRC_URI[sha256sum] = "a96265a22784c29888669f961a0896841d177853f8f057efe063e891962b9090"
