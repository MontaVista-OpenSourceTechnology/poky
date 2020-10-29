require qemu.inc

inherit ptest

RDEPENDS_${PN}-ptest = "bash make"

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

PR = "r26"

SRC_URI = "http://wiki.qemu-project.org/download/${BP}.tar.bz2 \
           file://powerpc_rom.bin \
           file://disable-grabs.patch \
           file://exclude-some-arm-EABI-obsolete-syscalls.patch \
           file://wacom.patch \
           file://add-ptest-in-makefile-v10.patch \
           file://run-ptest \
           file://qemu-enlarge-env-entry-size.patch \
           file://no-valgrind.patch \
           file://pathlimit.patch \
           file://qemu-2.5.0-cflags.patch \
           file://0001-Provide-support-for-the-CUSE-TPM.patch \
           file://0002-Introduce-condition-to-notify-waiters-of-completed-c.patch \
           file://0003-Introduce-condition-in-TPM-backend-for-notification.patch \
           file://0004-Add-support-for-VM-suspend-resume-for-TPM-TIS-v2.9.patch \
           file://apic-fixup-fallthrough-to-PIC.patch \
           file://CVE-2017-13711.patch \
           file://CVE-2017-13673.patch \
           file://CVE-2017-13672.patch \
           file://CVE-2017-14167.patch \
           file://ppc_locking.patch \
           file://memfd.patch \
           file://0001-CVE-2018-11806-QEMU-slirp-heap-buffer-overflow.patch \
           file://CVE-2017-15119.patch \
           file://CVE-2017-18043.patch \
           file://CVE-2018-7550.patch \
           file://CVE-2018-12617.patch \
           file://CVE-2018-16847.diff \
           file://CVE-2018-18438.diff \
           file://CVE-2018-19665.diff \
           file://CVE-2018-15746.patch \
           file://CVE-2018-17958.patch \
           file://CVE-2018-10839.patch \
           file://CVE-2018-17962.patch \
           file://CVE-2018-17963.patch \
           file://CVE-2018-18954.patch \
           file://CVE-2018-20815.patch \
           file://CVE-2018-20815_2.patch \
           file://CVE-2019-13164.patch \
           file://CVE-2019-15890.patch \
           file://CVE-2019-12068_p1.patch \
           file://CVE-2019-12068_p2.patch \
           file://CVE-2019-12068_p3.patch \
           file://CVE-2019-12068_p4.patch \
           file://CVE-2019-12068_p5.patch \
           file://CVE-2019-14378.patch \
           file://CVE-2019-6778.patch \
           file://CVE-2019-3812.patch \
           file://CVE-2018-19364.patch \
           file://CVE-2018-19489.patch \
           file://CVE-2019-12155.patch \
           file://CVE-2019-9824.patch \
           file://CVE-2019-20382.patch \
           file://CVE-2020-13253.patch \
           file://CVE-2020-13361.patch \
           file://CVE-2020-13659.patch \
           file://CVE-2020-16092.patch \
           file://CVE-2020-15863.patch \
           file://CVE-2020-13754_p1.patch \
           file://CVE-2020-13754_p2.patch \
           file://CVE-2020-13754_p3.patch \
           file://CVE-2020-13754_p4.patch \
           file://CVE-2020-13754_p5.patch \
           file://CVE-2020-13765.patch \
           "

UPSTREAM_CHECK_REGEX = "qemu-(?P<pver>\d+\..*)\.tar"


SRC_URI_append_class-native = " \
            file://fix-libcap-header-issue-on-some-distro.patch \
            file://cpus.c-qemu_cpu_kick_thread_debugging.patch \
            "

SRC_URI[md5sum] = "ca73441de73a9b52c6c49c97190d2185"
SRC_URI[sha256sum] = "7e9f39e1306e6dcc595494e91c1464d4b03f55ddd2053183e0e1b69f7f776d48"

COMPATIBLE_HOST_mipsarchn32 = "null"
COMPATIBLE_HOST_mipsarchn64 = "null"

do_install_append() {
    # Prevent QA warnings about installed ${localstatedir}/run
    if [ -d ${D}${localstatedir}/run ]; then rmdir ${D}${localstatedir}/run; fi
    install -Dm 0755 ${WORKDIR}/powerpc_rom.bin ${D}${datadir}/qemu
}

do_compile_ptest() {
	make buildtest-TESTS
}

do_install_ptest() {
	cp -rL ${B}/tests ${D}${PTEST_PATH}
	find ${D}${PTEST_PATH}/tests -type f -name "*.[Sshcod]" | xargs -i rm -rf {}

	cp ${S}/tests/Makefile.include ${D}${PTEST_PATH}/tests
}
