plugins {
    id("org.gradlex.extra-java-module-info")
    id("org.gradlex.java-module-testing")
}

extraJavaModuleInfo {
    failOnMissingModuleInfo = false
    failOnAutomaticModules = false
    deriveAutomaticModuleNamesFromFileNames = true

    module("org.wiremock:wiremock", "wiremock") {
        overrideModuleName()
        patchRealModule()
        exportAllPackages()

        requires("wiremock.slf4j.spi.shim")
        requires("com.fasterxml.jackson.core")
        requires("com.fasterxml.jackson.databind")
        requires("com.fasterxml.jackson.datatype.jsr310")
        requires("com.google.common")
        requires("commons.fileupload")
        requires("org.eclipse.jetty.server")
        requires("org.eclipse.jetty.servlet")
        requires("org.eclipse.jetty.servlets")
        requires("org.eclipse.jetty.webapp")
        requires("org.eclipse.jetty.proxy")
        requires("org.eclipse.jetty.http2.server")
        requires("org.eclipse.jetty.alpn.server")
        requires("org.eclipse.jetty.alpn.java.server")
        requires("org.eclipse.jetty.alpn.java.client")
        requires("org.eclipse.jetty.alpn.client")
        requires("java.xml")
        requires("org.custommonkey.xmlunit")
        requires("org.slf4j")
        requires("org.xmlunit")

        uses("com.github.tomakehurst.wiremock.extension.Extension")

        // workaround for https://github.com/wiremock/wiremock/issues/2874
        mergeJar("com.github.jknack:handlebars")
        mergeJar("com.github.jknack:handlebars-helpers")

        // Required to provide package "wiremock.org.slf4j.helpers"
        mergeJar("com.github.koppor:wiremock-slf4j-shim")
    }
}

javaModuleTesting.whitebox(testing.suites["test"]) {
    requires.add("wiremock")
    requires.add("wiremock.slf4j.spi.shim")
}
