SUMMARY = "IMG GPU Firmware Binary Blob"

LICENSE = "CLOSED"

require recipes-bsp/common/visionfive2-firmware.inc
inherit allarch

S = "${WORKDIR}/git"

CLEANBROKEN = "1"

IMG_GPU_POWERVR_VERSION = "img-gpu-powervr-bin-1.17.6210866"

do_install () {
    tar xz --no-same-owner -f ${S}/IMG_GPU/out/${IMG_GPU_POWERVR_VERSION}.tar.gz -C ${B}
    install -d ${D}/lib/firmware
    install -m 0644 ${IMG_GPU_POWERVR_VERSION}/target/lib/firmware/rgx.fw.36.50.54.182 ${D}/lib/firmware/
    install -m 0644 ${IMG_GPU_POWERVR_VERSION}/target/lib/firmware/rgx.sh.36.50.54.182 ${D}/lib/firmware/
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/"

INSANE_SKIP = "arch"