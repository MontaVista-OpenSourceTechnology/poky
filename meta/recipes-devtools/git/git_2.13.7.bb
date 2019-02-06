require git.inc

EXTRA_OECONF += "ac_cv_snprintf_returns_bogus=no \
                 ac_cv_fread_reads_directories=${ac_cv_fread_reads_directories=yes} \
                 "
EXTRA_OEMAKE += "NO_GETTEXT=1"

SRC_URI[tarball.md5sum] = "5a982c3ef10cdafa249a188c334a16f0"
SRC_URI[tarball.sha256sum] = "d9ac54f87d2877e0a92fad8c76657e3801726b29c2cc2dda8aca46cd28756504"
SRC_URI[manpages.md5sum] = "383a71d50c7deb71eaebc20d3d5ed037"
SRC_URI[manpages.sha256sum] = "de4f754d941606036687732e6b2cfd01864788f545a6894d84740e61fa7ec47b"
