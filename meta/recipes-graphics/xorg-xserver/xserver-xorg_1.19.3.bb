require xserver-xorg.inc

SRC_URI += "file://musl-arm-inb-outb.patch \
            file://0001-configure.ac-Fix-check-for-CLOCK_MONOTONIC.patch \
            file://0002-configure.ac-Fix-wayland-scanner-and-protocols-locat.patch \
            file://0003-modesetting-Fix-16-bit-depth-bpp-mode.patch \
            file://0003-Remove-check-for-useSIGIO-option.patch \
            file://CVE-2017-10971-1.patch \
            file://CVE-2017-10971-2.patch \
            file://CVE-2017-10971-3.patch \
            file://CVE-2018-14665.patch \
            file://CVE-2020-14361.patch \
            file://CVE-2020-14345.patch \
            file://CVE-2020-14347.patch \
            file://CVE-2020-14346-p1.patch \
            file://CVE-2020-14346-p2.patch \
            file://CVE-2020-14362.patch \
	    file://CVE-2020-14360.patch \
	    file://CVE-2021-3472.patch \
	    file://0001-CVE-2020-25712.patch \
	    file://0001-CVE-2021-4008.patch \
	    file://0001-CVE-2021-4011.patch \
            file://CVE-2022-46340.patch \
            file://CVE-2022-46341.patch \
            file://CVE-2022-46342.patch \
            file://CVE-2022-46343.patch \
            file://CVE-2022-46344-1.patch \
            file://CVE-2022-46344-2.patch \
            file://CVE-2022-4283.patch \
            file://CVE-2023-0494.patch \
            file://CVE-2023-1393.patch \
            "
SRC_URI[md5sum] = "015d2fc4b9f2bfe7a626edb63a62c65e"
SRC_URI[sha256sum] = "677a8166e03474719238dfe396ce673c4234735464d6dadf2959b600d20e5a98"
PR .= ".12"
# These extensions are now integrated into the server, so declare the migration
# path for in-place upgrades.

RREPLACES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RPROVIDES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RCONFLICTS_${PN} = "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "