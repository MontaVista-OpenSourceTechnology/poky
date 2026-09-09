SUMMARY = "A small utility for printing debug source file locations embedded in binaries"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://../dwarfsrcfiles.c;md5=f6b79f0ced6baa016d4c7c7189853c0d;beginline=1;endline=8"

SRC_URI = "file://dwarfsrcfiles.c"
BBCLASSEXTEND = "native"
DEPENDS = "elfutils"
DEPENDS_append_libc-musl = " argp-standalone"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} -o dwarfsrcfiles ../dwarfsrcfiles.c -lelf -ldw
}

do_compile_libc-musl () {
	${CC} ${CFLAGS} ${LDFLAGS} -o dwarfsrcfiles ../dwarfsrcfiles.c -lelf -ldw -largp
}

do_install () {
	install -d ${D}${bindir}
	install -t ${D}${bindir} dwarfsrcfiles
}
