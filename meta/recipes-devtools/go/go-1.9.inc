require go-common.inc

GO_BASEVERSION = "1.9"
GO_MINOR = ".4"
PV .= "${GO_MINOR}"

PR .= ".34"

FILESEXTRAPATHS_prepend := "${FILE_DIRNAME}/go-${GO_BASEVERSION}:"

LIC_FILES_CHKSUM = "file://LICENSE;md5=5d4950ecb7b26d2c5e4e7b4e0dd74707"

SRC_URI += "\
        file://0001-make.bash-quote-CC_FOR_TARGET.patch \
        file://0002-cmd-go-fix-CC-and-CXX-environment-variable-construct.patch \
        file://0003-make.bash-better-separate-host-and-target-builds.patch \
        file://0004-cmd-go-allow-GOTOOLDIR-to-be-overridden-in-the-envir.patch \
        file://0005-cmd-go-make-GOROOT-precious-by-default.patch \
        file://0006-make.bash-add-GOTOOLDIR_BOOTSTRAP-environment-variab.patch \
        file://0007-ld-add-soname-to-shareable-objects.patch \
        file://0008-make.bash-add-GOHOSTxx-indirection-for-cross-canadia.patch \
        file://0009-cmd-go-buildmode-pie-forces-external-linking-mode-on.patch \
        file://0010-make.bash-override-CC-when-building-dist-and-go_boot.patch \
        file://CVE-2018-16873.patch \
        file://CVE-2018-16875.patch \
	file://CVE-2019-16276_dep_p1.patch \
	file://CVE-2019-16276_dep_p2.patch \
	file://CVE-2019-16276_dep_p3.patch \
	file://CVE-2019-16276_p4.patch \
	file://CVE-2019-6486.patch \
	file://CVE-2019-17596.patch \
	file://CVE-2019-9514.patch \
	file://CVE-2019-9741_p1.patch \
	file://CVE-2019-9741_p2.patch \
	file://CVE-2019-14809.patch \
	file://0001-CVE-2021-29923.patch \
	file://0001-CVE-2020-28367.patch \
	file://CVE-2020-16845.patch \
	file://CVE-2021-3114.patch \
	file://CVE-2020-24553.patch \
	file://0001-CVE-2021-34558.patch \
	file://0001-CVE-2020-15586.patch \
	file://0001-CVE-2021-33195.patch \
	file://0001-CVE-2021-41771.patch \
	file://0001-CVE-2021-27918.patch \
	file://0001-CVE-2021-44716.patch \
	file://0001-CVE-2021-39293.patch \
	file://0001-CVE-2022-23806.patch \
	file://0001-CVE-2022-24921.patch \
        file://CVE-2022-27664.patch \
        file://CVE-2021-44717.patch \
        file://CVE-2021-31525.patch \
        file://CVE-2022-30631.patch \
        file://CVE-2022-30632.patch \
        file://CVE-2022-30633.patch \
        file://CVE-2022-30635.patch \
        file://CVE-2022-32189.patch \
        file://CVE-2022-32190-p1.patch \
        file://CVE-2022-32190-p2.patch \
        file://CVE-2022-32190-p3.patch \
        file://CVE-2022-32190-p4.patch \
        file://CVE-2022-41715.patch \
        file://CVE-2022-2880.patch \
        file://CVE-2021-33197.patch \
        file://CVE-2020-14040.patch \
        file://CVE-2022-32148.patch \
        file://0001-CGX-2.4-go-native-failed-to-build.patch \
        file://CVE-2022-41717.patch \
        file://CVE-2022-24675.patch \
        file://CVE-2022-41723.patch \
        file://CVE-2021-33196.patch \
        file://CVE-2023-24534.patch \
        file://CVE-2023-24538-1.patch \
        file://CVE-2023-24538-2.patch \
        file://CVE-2023-24538-3.patch \
        file://CVE-2023-24538-4.patch \
        file://CVE-2023-24540.patch \
        file://CVE-2023-24539.patch \
        file://CVE-2023-29400.patch \
        file://CVE-2023-29405.patch \
"
SRC_URI_append_libc-musl = " file://set-external-linker.patch"

SRC_URI[main.md5sum] = "6816441fd6680c63865cdd5cb8bc1960"
SRC_URI[main.sha256sum] = "0573a8df33168977185aa44173305e5a0450f55213600e94541604b75d46dc06"
