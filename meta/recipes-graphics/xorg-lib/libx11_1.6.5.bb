require libx11.inc
inherit gettext

BBCLASSEXTEND = "native nativesdk"

PR = "r4"
SRC_URI += "file://disable_tests.patch \
            file://Fix-hanging-issue-in-_XReply.patch \
            file://CVE-2018-14599.patch \
            file://CVE-2018-14600.patch \
            file://CVE-2018-14598.patch \
            file://CVE-2020-14344-p1.patch \
            file://CVE-2020-14344-p2.patch \
            file://CVE-2020-14344-p3.patch \
            file://CVE-2020-14344-p4.patch \
            file://CVE-2020-14344-p5.patch \
            file://CVE-2020-14344-p6.patch \
            file://CVE-2020-14344-p7.patch \
            file://CVE-2020-14363.patch \
           "
do_configure_append () {
    sed -i -e "/X11_CFLAGS/d" ${B}/src/util/Makefile
}

SRC_URI[md5sum] = "0f618db70c4054ca67cee0cc156a4255"
SRC_URI[sha256sum] = "4d3890db2ba225ba8c55ca63c6409c1ebb078a2806de59fb16342768ae63435d"
