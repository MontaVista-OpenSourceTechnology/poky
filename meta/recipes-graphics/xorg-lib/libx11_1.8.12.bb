SUMMARY = "Xlib: C Language X Interface library"

DESCRIPTION = "This package provides a client interface to the X Window \
System, otherwise known as 'Xlib'.  It provides a complete API for the \
basic functions of the window system."

require xorg-lib-common.inc

LICENSE = "MIT & BSD-1-Clause & HPND & HPND-sell-variant & ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=1d49cdd2b386c5db11ec636d680b7116"

DEPENDS += "xorgproto \
            xtrans \
            libxcb \
            xorgproto-native \
            autoconf-archive-native \
            "

PROVIDES = "virtual/libx11"

PE = "1"

XORG_PN = "libX11"

SRC_URI += "file://disable_tests.patch"

SRC_URI[sha256sum] = "fa026f9bb0124f4d6c808f9aef4057aad65e7b35d8ff43951cef0abe06bb9a9a"

inherit gettext

EXTRA_OECONF += "--with-keysymdefdir=${STAGING_INCDIR}/X11/ --disable-xf86bigfont"
EXTRA_OEMAKE += 'CWARNFLAGS=""'

PACKAGECONFIG ??= "xcms"
PACKAGECONFIG[xcms] = "--enable-xcms,--disable-xcms"

PACKAGES =+ "${PN}-xcb"

FILES:${PN} += "${datadir}/X11/XKeysymDB ${datadir}/X11/XErrorDB ${datadir}/X11/Xcms.txt"
FILES:${PN}-xcb += "${libdir}/libX11-xcb.so.*"
FILES:${PN}-locale += "${datadir}/X11/locale ${libdir}/X11/locale"

BBCLASSEXTEND = "native nativesdk"
