require git.inc

EXTRA_OECONF += "ac_cv_snprintf_returns_bogus=no \
                 ac_cv_fread_reads_directories=${ac_cv_fread_reads_directories=yes} \
                 "
EXTRA_OEMAKE += "NO_GETTEXT=1"

SRC_URI[tarball.md5sum] = "0cbe560e86a96c3223d545a2fa8c9ead"
SRC_URI[tarball.sha256sum] = "8f6434af7b1c7ee91f281f3f2bb88236992ac48699fdecaea8d855b722e37e96"
SRC_URI[manpages.md5sum] = "f8f6cc00e82b45b92caaa2db518df442"
SRC_URI[manpages.sha256sum] = "434eaad341acb0b6cc884154d469f145aab86f3cef8e66101681581b15031fa4"

PR .= ".8"
SRC_URI += "file://CVE-2018-19486.patch \
            file://CVE-2020-5260_p1.patch \
            file://CVE-2020-5260_p2.patch \
            file://CVE-2020-5260_p3.patch \
            file://CVE-2020-5260_p4.patch \
            file://CVE-2020-11008_p1.patch \
            file://CVE-2020-11008_p2.patch \
            file://CVE-2020-11008_p3.patch \
            file://CVE-2020-11008_p4.patch \
            file://CVE-2020-11008_p5.patch \
            file://CVE-2020-11008_p6.patch \
            file://CVE-2020-11008_p7.patch \
            file://CVE-2020-11008_p8.patch \
            file://CVE-2020-11008_p9.patch \
            file://CVE-2021-40330.patch \
            file://0001-CVE-2021-21300.patch \
            file://CVE-2022-24765-1.patch \
            file://CVE-2022-24765-2-pre.patch \
            file://CVE-2022-24765-2.patch \
            file://CVE-2022-24765-3.patch \
            file://CVE-2022-24765-4.patch \
            file://CVE-2022-24765-5.patch \
            file://CVE-2022-24765-6.patch \
            file://CVE-2022-29187-1.patch \
            file://CVE-2022-29187-2.patch \
            file://CVE-2022-29187-3.patch \
            file://CVE-2022-29187-4.patch \
            file://CVE-2022-29187-5.patch \
            file://CVE-2022-29187-6.patch \
            file://CVE-2022-39253-1.patch \
            file://CVE-2022-39253-2.patch \
            file://CVE-2022-39253-3.patch \
            file://CVE-2022-39253-5.patch \
            file://CVE-2022-39253-6.patch \
            file://CVE-2022-39253-7.patch \
            file://CVE-2022-39253-8.patch \
            file://CVE-2022-39253-9.patch \
            file://CVE-2022-39253-10.patch \
            file://CVE-2022-39253-11.patch \
            file://CVE-2022-39253-12.patch \
            file://CVE-2022-39260-1.patch \
            file://CVE-2022-39260-2.patch \
            file://CVE-2022-39260-3.patch \
            file://CVE-2022-23521-pre.patch \
            file://CVE-2022-23521-pre2.patch \
            file://CVE-2022-23521-1.patch \
            file://CVE-2022-23521-2.patch \
            file://CVE-2022-23521-3.patch \
            file://CVE-2022-23521-4.patch \
            file://CVE-2022-23521-5.patch \
            file://CVE-2022-23521-6.patch \
            file://CVE-2022-23521-7.patch \
            file://CVE-2022-23521-8.patch \
            file://CVE-2022-23521-9.patch \
            file://CVE-2022-23521-10.patch \
           "
