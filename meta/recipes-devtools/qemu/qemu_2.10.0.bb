require qemu.inc

inherit ptest

RDEPENDS_${PN}-ptest = "bash make"

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

PR = "r32"

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
           file://CVE-2020-12829_pre1.patch \
           file://CVE-2020-12829_pre2.patch \
           file://CVE-2020-12829_pre3.patch \
           file://CVE-2020-12829_pre4.patch \
           file://CVE-2020-12829_pre5.patch \
           file://CVE-2020-12829_pre6.patch \
           file://CVE-2020-12829_pre7.patch \
           file://CVE-2020-12829_pre8.patch \
           file://CVE-2020-12829_pre9.patch \
           file://CVE-2020-12829_pre10.patch \
           file://CVE-2020-12829_p1.patch \
           file://CVE-2020-12829_p2.patch \
           file://CVE-2020-12829_p3.patch \
           file://CVE-2020-12829_p4.patch \
           file://CVE-2020-12829_p5.patch \
           file://CVE-2020-12829_p6.patch \
           file://CVE-2020-12829_p7.patch \
           file://CVE-2020-25625.patch \
           file://CVE-2020-25085.patch \
           file://CVE-2020-14364.patch \
	   file://CVE-2019-12067.patch \
	   file://CVE-2019-20175.patch \
	   file://CVE-2020-28916.patch \
	   file://CVE-2020-29443_p1.patch \
	   file://CVE-2020-29443_p2.patch \
	   file://CVE-2020-25624.patch \
	   file://CVE-2020-25723.patch \
	   file://CVE-2020-27617.patch \
	   file://CVE-2021-20181.patch \
	   file://CVE-2021-20221.patch \
	   file://CVE-2021-20255.patch \
	   file://CVE-2021-20257.patch \
	   file://CVE-2021-3409.patch \
	   file://CVE-2021-3527.patch \
	   file://CVE-2021-3682.patch \
	   file://CVE-2021-3409_p1.patch \
	   file://CVE-2021-3409_p2.patch \
	   file://CVE-2021-3409_p3.patch \
	   file://CVE-2021-3409_p4.patch \
	   file://CVE-2021-3409_p5.patch \
	   file://0001-CVE-2021-3713.patch \
           file://0001-linux-user-rename-gettid-to-sys_gettid-to-avoid-clas.patch \
           file://0001-linux-user-remove-host-stime-syscall.patch \
           file://0001-CVE-2021-3748.patch \
           file://0001-CVE-2022-26353.patch \
           file://CVE-2021-3930.patch \
	   file://0001-CVE-2021-4206.patch \
           file://0001-CVE-2022-0216-1.patch \
           file://0001-CVE-2022-0216-2.patch \
           file://0001-CVE-2022-26354.patch \
           file://0001-CVE-2021-20196-1.patch \
           file://0001-CVE-2021-20196-2.patch \
           file://CVE-2020-35504.patch \
           file://CVE-2020-35505.patch \
           file://0001-CVE-2021-3750.patch \
           file://CVE-2021-3507.patch \
           file://CVE-2022-4144-1.patch \
           file://CVE-2022-4144-2.patch \
           file://CVE-2022-4144-3_pre1.patch \
           file://CVE-2022-4144-3_pre2.patch \
           file://CVE-2022-4144-3.patch \
           file://CVE-2022-4144-4.patch \
           file://CVE-2022-4144-5.patch \
           file://0001-qxl-remove-assert-in-qxl_pre_save.patch \
           file://0001-Revert-qxl-add-migration-blocker-to-avoid-pre-save-a.patch \
           file://0001-qxl-fix-pre-save-logic.patch \
           file://CVE-2023-0330.patch \
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
