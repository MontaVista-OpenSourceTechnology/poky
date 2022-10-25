MAJOR_VERSION = "2.30"
require util-linux.inc

# To support older hosts, we need to patch and/or revert
# some upstream changes.  Only do this for native packages.
OLDHOST = ""
OLDHOST_class-native = "file://util-linux-native-qsort.patch"

PR = "r3.1"

SRC_URI += "file://configure-sbindir.patch \
            file://runuser.pamd \
            file://runuser-l.pamd \
            ${OLDHOST} \
            file://ptest.patch \
            file://run-ptest \
            file://display_testname_for_subtest.patch \
            file://avoid_parallel_tests.patch \
            file://CVE-2018-7738.patch \
            file://lib-randutils.c-Fall-back-gracefully-when-kernel-doe.patch \
            file://lib-randutils.c-More-paranoia-in-getrandom-call.patch \
            file://lib-randutils-improve-getrandom-usage.patch \
            file://lib-randutils-reset-lose-counter.patch \
            file://lib-randutils-remove-superfluous-continue.patch \
            file://lib-randutils-Do-not-block-on-getrandom.patch \
            file://lib-randutils-don-t-break-on-EAGAIN-use-usleep.patch \
            file://0001-CVE-2022-0563.patch \
            file://CVE-2021-37600.patch \
"
SRC_URI[md5sum] = "eaa3429150268027908a1b8ae6ee9a62"
SRC_URI[sha256sum] = "c208a4ff6906cb7f57940aa5bc3a6eed146e50a7cc0a092f52ef2ab65057a08d"

CACHED_CONFIGUREVARS += "scanf_cv_alloc_modifier=ms"

EXTRA_OECONF_class-native = "${SHARED_EXTRA_OECONF} \
                             --disable-fallocate \
			     --disable-use-tty-group \
"
EXTRA_OECONF_class-nativesdk = "${SHARED_EXTRA_OECONF} \
                                --disable-fallocate \
				--disable-use-tty-group \
"
