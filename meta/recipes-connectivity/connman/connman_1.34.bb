require connman.inc

PR .= ".2"
SRC_URI  = "${KERNELORG_MIRROR}/linux/network/${BPN}/${BP}.tar.xz \
            file://0001-plugin.h-Change-visibility-to-default-for-debug-symb.patch \
            file://0001-firewall-nftables-fix-build-with-libnftnl-1.0.7.patch \
            file://0001-connman.service-stop-systemd-resolved-when-we-use-co.patch \
            file://connman \
            file://no-version-scripts.patch \
            file://includes.patch \
            file://CVE-2017-12865.patch \
            file://0001-CVE-2022-23096-CVE-2022-23097-connman.patch \
	    file://0001-CVE-2022-23098.patch \
            file://0001-CVE-2022-32292.patch \
            file://0001-CVE-2022-32293.patch \
            "
SRC_URI_append_libc-musl = " file://0002-resolve-musl-does-not-implement-res_ninit.patch \
                             "

SRC_URI[md5sum] = "e200028702c831d5f535d20d61e608ef"
SRC_URI[sha256sum] = "a9a0808c729c1f348fc36d8cecb52d19b72bc34cb411c502608cb0e0190fc71e"

RRECOMMENDS_${PN} = "connman-conf"
