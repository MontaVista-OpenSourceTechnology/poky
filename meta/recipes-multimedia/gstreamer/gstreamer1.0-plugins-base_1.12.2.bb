require gstreamer1.0-plugins-base.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607"

PR .= ".2"

SRC_URI = " \
    http://gstreamer.freedesktop.org/src/gst-plugins-base/gst-plugins-base-${PV}.tar.xz \
    file://get-caps-from-src-pad-when-query-caps.patch \
    file://0003-ssaparse-enhance-SSA-text-lines-parsing.patch \
    file://0004-subparse-set-need_segment-after-sink-pad-received-GS.patch \
    file://make-gio_unix_2_0-dependency-configurable.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://0001-CVE-2021-3522.patch \
    file://CVE-2024-47538.patch \
    file://CVE-2024-47541-1.patch \
    file://CVE-2024-47541-2.patch \
    file://CVE-2024-47542.patch \
    file://CVE-2024-47607.patch \
    file://CVE-2024-47615-pre1.patch \
    file://CVE-2024-47615-1.patch \
    file://CVE-2024-47615-2.patch \
    file://CVE-2024-47835.patch \
"
SRC_URI[md5sum] = "77f5379c4ca677616b415e3b3ff95578"
SRC_URI[sha256sum] = "5067dce3afe197a9536fea0107c77213fab536dff4a213b07fc60378d5510675"

S = "${WORKDIR}/gst-plugins-base-${PV}"
