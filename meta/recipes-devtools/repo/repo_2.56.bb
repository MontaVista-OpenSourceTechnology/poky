# SPDX-License-Identifier: MIT
# Copyright (C) 2021 iris-GmbH infrared & intelligent sensors

SUMMARY = "Tool for managing many Git repositories"
DESCRIPTION = "Repo is a tool built on top of Git. Repo helps manage many Git repositories, does the uploads to revision control systems, and automates parts of the development workflow."
HOMEPAGE = "https://android.googlesource.com/tools/repo"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://gerrit.googlesource.com/git-repo.git;protocol=https;branch=main;tag=v${PV} \
           "
SRCREV = "99b5a17f2c951fe5979100c36e7e1dbb4c61b36c"

MIRRORS += "git://gerrit.googlesource.com/git-repo.git git://github.com/GerritCodeReview/git-repo.git"

do_configure:prepend() {
	sed -Ei "s/REPO_REV\s*=\s*('|\")stable('|\")/REPO_REV = '${SRCREV}'/g" ${S}/repo
}

do_install() {
	install -D ${S}/repo ${D}${bindir}/repo
}

RDEPENDS:${PN} = "python3 git"

BBCLASSEXTEND = "native nativesdk"
