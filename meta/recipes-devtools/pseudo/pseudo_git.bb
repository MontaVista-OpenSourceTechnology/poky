require pseudo.inc

SRC_URI = "git://git.yoctoproject.org/pseudo;branch=pseudo-1.9;protocol=https \
           file://fallback-passwd \
           file://fallback-group \
           file://0001-test-Skip-open_tree-tests-when-the-function-or-sysca.patch \
           file://0002-makewrappers-Don-t-generate-unused-_int-paths-with-n.patch \
           file://0003-ports-linux-Don-t-require-linux-mount.h.patch \
           file://0004-configure-Require-GCC-5-or-later.patch \
           file://0005-pseudo_client-serialize-path-changes-across-clients.patch \
           file://0006-ports-hold-the-path-lock-in-create-and-metadata-wrap.patch \
           file://0007-ports-check-created-files-under-the-path-lock-before.patch \
           file://0008-test-parallel-ops-Add-a-parallel-create-rename-link-.patch \
           file://0009-README.security-Add-information-specific-to-file-pro.patch \
           file://0010-AGENTS.md-Add-to-assist-future-developers.patch \
           "
SRC_URI:append:class-native = " \
    http://downloads.yoctoproject.org/mirror/sources/pseudo-prebuilt-2.33.tar.xz;subdir=git/prebuilt;name=prebuilt \
    file://older-glibc-symbols.patch"
SRC_URI:append:class-nativesdk = " \
    http://downloads.yoctoproject.org/mirror/sources/pseudo-prebuilt-2.33.tar.xz;subdir=git/prebuilt;name=prebuilt \
    file://older-glibc-symbols.patch"
SRC_URI[prebuilt.sha256sum] = "ed9f456856e9d86359f169f46a70ad7be4190d6040282b84c8d97b99072485aa"

SRCREV = "e627b0dcb639f387db935fae1f9b93b30cded5e1"
S = "${WORKDIR}/git"
PV = "1.9.12+git"

# largefile and 64bit time_t support adds these macros via compiler flags globally
# remove them for pseudo since pseudo intercepts some of the functions which will be
# aliased due to this e.g. open/open64 and it will complain about duplicate definitions
# pseudo on 32bit systems is not much of use anyway and these features are not of much
# use for it.
TARGET_CC_ARCH:remove = "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64 -D_TIME_BITS=64"

# error: use of undeclared identifier '_STAT_VER'
COMPATIBLE_HOST:libc-musl = 'null'
