require gstreamer1.0-plugins-good.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343 \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607 \
                    file://gst/replaygain/rganalysis.c;beginline=1;endline=23;md5=b60ebefd5b2f5a8e0cab6bfee391a5fe"

PR .= ".5"
SRC_URI = " \
    http://gstreamer.freedesktop.org/src/gst-plugins-good/gst-plugins-good-${PV}.tar.xz \
    file://0001-gstrtpmp4gpay-set-dafault-value-for-MPEG4-without-co.patch \
    file://avoid-including-sys-poll.h-directly.patch \
    file://ensure-valid-sentinel-for-gst_structure_get.patch \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://0001-v4l2-Fix-4K-colorimetry.patch \
    file://CVE-2024-47606.patch \
    file://CVE-2024-47613.patch \
    file://CVE-2024-47774.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-pre1.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-1.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-2.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-3.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-4.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-5.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-6.patch \
    file://CVE-2024-47540_47601_47602_47603_47834-7.patch \
    file://CVE-2024-47775_47776_47777_47778-1.patch \
    file://CVE-2024-47775_47776_47777_47778-2.patch \
    file://CVE-2024-47775_47776_47777_47778-3.patch \
    file://CVE-2024-47775_47776_47777_47778-4.patch \
    file://CVE-2024-47775_47776_47777_47778-5.patch \
    file://CVE-2024-47775_47776_47777_47778-6.patch \
    file://CVE-2024-47775_47776_47777_47778-7.patch \
    file://CVE-2024-47537-p1.patch \
    file://CVE-2024-47537-p2.patch \
    file://CVE-2024-47537-p3.patch \
    file://qtdemux-Ignore-corrupted-CTTS-box.patch \
    file://qtdemux-Add-a-minimum-buffer-size-for-raw-audio-to-n.patch \
    file://qtdemux-Merge-sample-tables-for-raw-audio-streams-wi.patch \
    file://CVE-2024-47598.patch \
    file://qtdemux-Detect-and-expose-CEA-608-708-Closed-Caption.patch \
    file://CVE-2024-47539.patch \
    file://CVE-2024-47543.patch \
    file://qtdemux_parse_segments-remove-superfluous-variable.patch \
    file://qtdemux-Factor-out-svmi-parsing.-Fix-bounds-checking.patch \
    file://qtdemux-use-unsigned-int-types-to-store-result-of-QT.patch \
    file://qtdemux-Skip-zero-sized-boxes-instead-of-stopping-to.patch \
    file://CVE-2024-47545.patch \
    file://CVE-2024-47544.patch \
    file://CVE-2024-47597-p1.patch \
    file://qtdemux-reset-reused-QtDemuxStream-while-parsing-a-n.patch \
    file://qtdemux-Add-parentheses-in-macro.patch \
    file://qtdemux-Adjust-the-number-of-args-of-some-functions.patch \
    file://qtdemux-preferably-send-open-ended-segment-rather-th.patch \
    file://qtdemux-fix-seeking-in-fragmented-file-without-mfra-.patch \
    file://qtdemux-Check-presence-of-bitrate-tags.patch \
    file://qtdemux-Use-GList-to-manage-QtDemuxStream.patch \
    file://qtdemux-Store-stream-id-to-manage-streams.patch \
    file://qtdemux-Create-stream-whenever-got-new-moov.patch \
    file://qtdemux-Remove-duplication-of-initializing-member-va.patch \
    file://qtdemux-Try-to-expose-whenever-got-new-moov-or-new-s.patch \
    file://qtdemux-Protect-_expose_streams-from-flush-event.patch \
    file://CVE-2024-47597-p2.patch \
    file://CVE-2024-47546.patch \
    file://CVE-2024-47596.patch \
    file://jpegdec-Handle-interlaced-MJPEG-streams.patch \
    file://jpeg-Fixup-frames-without-an-EOI-marker.patch \
    file://jpegdec-Check-return-value-of-gst_buffer_map.patch \
    file://CVE-2024-47599.patch \
"
SRC_URI[md5sum] = "20254217d9805484532e08ff1c3aa296"
SRC_URI[sha256sum] = "5591ee7208ab30289a30658a82b76bf87169c927572d9b794f3a41ed48e1ee96"

S = "${WORKDIR}/gst-plugins-good-${PV}"

RPROVIDES_${PN}-pulseaudio += "${PN}-pulse"
RPROVIDES_${PN}-soup += "${PN}-souphttpsrc"
