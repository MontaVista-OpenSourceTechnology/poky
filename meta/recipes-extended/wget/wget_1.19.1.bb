PR = "r3"
SRC_URI = "${GNU_MIRROR}/wget/wget-${PV}.tar.gz \
           file://0001-Unset-need_charset_alias-when-building-for-musl.patch \
           file://CVE-2017-6508.patch \
           file://0001-Fix-cookie-injection-CVE-2018-0494.patch \
           file://CVE-2018-20483.patch \
           file://CVE-2019-5953-p1.patch \
           file://CVE-2019-5953-p2.patch \
          "

SRC_URI[md5sum] = "87cea36b7161fd43e3fd51a4e8b89689"
SRC_URI[sha256sum] = "9e4f12da38cc6167d0752d934abe27c7b1599a9af294e73829be7ac7b5b4da40"

require wget.inc