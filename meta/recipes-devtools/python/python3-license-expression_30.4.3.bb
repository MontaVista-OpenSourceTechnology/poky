SUMMARY = "Utility library to parse, compare, simplify and normalize license expressions"
HOMEPAGE = "https://github.com/nexB/license-expression"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://apache-2.0.LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "49f439fea91c4d1a642f9f2902b58db1d42396c5e331045f41ce50df9b40b1f2"

inherit pypi ptest-python-pytest python_setuptools_build_meta
PYPI_PACKAGE = "license_expression"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-booleanpy \
    python3-core \
    python3-json \
    python3-stringold \
    python3-logging \
"

BBCLASSEXTEND = "native nativesdk"

do_install_ptest:append() {
    # The tests need some files from the source tree
    install -d ${D}${PTEST_PATH}/src
    ln -s ${PYTHON_SITEPACKAGES_DIR}/license_expression/ ${D}${PTEST_PATH}/src/
    install -m644 ${S}/setup.cfg ${D}${PTEST_PATH}/
}
