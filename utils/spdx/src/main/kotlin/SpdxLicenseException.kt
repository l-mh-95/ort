/*
 * Copyright (C) 2017-2021 HERE Europe B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * License-Filename: LICENSE
 */

@file:Suppress("MaxLineLength")

package org.ossreviewtoolkit.utils.spdx

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * An enum containing all SPDX license exception IDs. This class is generated by the Gradle task
 * 'generateSpdxLicenseExceptionEnum'.
 */
@Suppress("EnumNaming")
enum class SpdxLicenseException(
    /**
     * The SPDX id of the license exception.
     */
    val id: String,

    /**
     * The human-readable name of the license exception.
     */
    val fullName: String,

    /**
     * Whether the [id] is deprecated or not.
     */
    val deprecated: Boolean = false
) {
    AUTOCONF_EXCEPTION_2_0("Autoconf-exception-2.0", "Autoconf exception 2.0"),
    AUTOCONF_EXCEPTION_3_0("Autoconf-exception-3.0", "Autoconf exception 3.0"),
    BISON_EXCEPTION_2_2("Bison-exception-2.2", "Bison exception 2.2"),
    BOOTLOADER_EXCEPTION("Bootloader-exception", "Bootloader Distribution Exception"),
    CLASSPATH_EXCEPTION_2_0("Classpath-exception-2.0", "Classpath exception 2.0"),
    CLISP_EXCEPTION_2_0("CLISP-exception-2.0", "CLISP exception 2.0"),
    DIGIRULE_FOSS_EXCEPTION("DigiRule-FOSS-exception", "DigiRule FOSS License Exception"),
    ECOS_EXCEPTION_2_0("eCos-exception-2.0", "eCos exception 2.0"),
    FAWKES_RUNTIME_EXCEPTION("Fawkes-Runtime-exception", "Fawkes Runtime Exception"),
    FLTK_EXCEPTION("FLTK-exception", "FLTK exception"),
    FONT_EXCEPTION_2_0("Font-exception-2.0", "Font exception 2.0"),
    FREERTOS_EXCEPTION_2_0("freertos-exception-2.0", "FreeRTOS Exception 2.0"),
    GCC_EXCEPTION_2_0("GCC-exception-2.0", "GCC Runtime Library exception 2.0"),
    GCC_EXCEPTION_3_1("GCC-exception-3.1", "GCC Runtime Library exception 3.1"),
    GNU_JAVAMAIL_EXCEPTION("gnu-javamail-exception", "GNU JavaMail exception"),
    GPL_3_0_LINKING_EXCEPTION("GPL-3.0-linking-exception", "GPL-3.0 Linking Exception"),
    GPL_3_0_LINKING_SOURCE_EXCEPTION("GPL-3.0-linking-source-exception", "GPL-3.0 Linking Exception (with Corresponding Source)"),
    GPL_CC_1_0("GPL-CC-1.0", "GPL Cooperation Commitment 1.0"),
    I2P_GPL_JAVA_EXCEPTION("i2p-gpl-java-exception", "i2p GPL+Java Exception"),
    LGPL_3_0_LINKING_EXCEPTION("LGPL-3.0-linking-exception", "LGPL-3.0 Linking Exception"),
    LIBTOOL_EXCEPTION("Libtool-exception", "Libtool Exception"),
    LINUX_SYSCALL_NOTE("Linux-syscall-note", "Linux Syscall Note"),
    LLVM_EXCEPTION("LLVM-exception", "LLVM Exception"),
    LZMA_EXCEPTION("LZMA-exception", "LZMA exception"),
    MIF_EXCEPTION("mif-exception", "Macros and Inline Functions Exception"),
    NOKIA_QT_EXCEPTION_1_1("Nokia-Qt-exception-1.1", "Nokia Qt LGPL exception 1.1", true),
    OCAML_LGPL_LINKING_EXCEPTION("OCaml-LGPL-linking-exception", "OCaml LGPL Linking Exception"),
    OCCT_EXCEPTION_1_0("OCCT-exception-1.0", "Open CASCADE Exception 1.0"),
    OPENJDK_ASSEMBLY_EXCEPTION_1_0("OpenJDK-assembly-exception-1.0", "OpenJDK Assembly exception 1.0"),
    OPENVPN_OPENSSL_EXCEPTION("openvpn-openssl-exception", "OpenVPN OpenSSL Exception"),
    PS_OR_PDF_FONT_EXCEPTION_20170817("PS-or-PDF-font-exception-20170817", "PS/PDF font exception (2017-08-17)"),
    QT_GPL_EXCEPTION_1_0("Qt-GPL-exception-1.0", "Qt GPL exception 1.0"),
    QT_LGPL_EXCEPTION_1_1("Qt-LGPL-exception-1.1", "Qt LGPL exception 1.1"),
    QWT_EXCEPTION_1_0("Qwt-exception-1.0", "Qwt exception 1.0"),
    SHL_2_0("SHL-2.0", "Solderpad Hardware License v2.0"),
    SHL_2_1("SHL-2.1", "Solderpad Hardware License v2.1"),
    SWIFT_EXCEPTION("Swift-exception", "Swift Exception"),
    UNIVERSAL_FOSS_EXCEPTION_1_0("Universal-FOSS-exception-1.0", "Universal FOSS Exception, Version 1.0"),
    U_BOOT_EXCEPTION_2_0("u-boot-exception-2.0", "U-Boot exception 2.0"),
    WXWINDOWS_EXCEPTION_3_1("WxWindows-exception-3.1", "WxWindows Library Exception 3.1"),
    _389_EXCEPTION("389-exception", "389 Directory Server Exception");

    companion object {
        /**
         * The map which associates SPDX exceptions with their applicable SPDX licenses.
         */
        val mapping by lazy {
            val resource = javaClass.getResource("/exception-mapping.yml")
            yamlMapper.readValue<Map<SpdxLicenseException, List<SpdxLicense>>>(resource)
        }

        /**
         * Return the enum value for the given [id], or null if it is no SPDX license exception id.
         */
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        @JvmStatic
        fun forId(id: String) =
            values().find { id.equals(it.id, ignoreCase = true) || id.equals(it.fullName, ignoreCase = true) }
    }

    /**
     * The full license exception text as a string.
     */
    val text by lazy { javaClass.getResource("/exceptions/$id").readText() }
}
