# wireshark mwe

Minimal example showing how to run modularized wireshark.

## Background

Handlebars needs to be updated from 4.3.1 to 4.4.0. Their Java Module System Fix is included in 4.4.0 (and not 4.3.1) - <https://github.com/jknack/handlebars.java/issues/1018>.

Using handlebars 4.4.0 is blocked by Java 11 compatibility of Wiremock. See <https://github.com/wiremock/wiremock/issues/2874>.

When using Gradle, one can use [Extra Java Module Info Gradle plugin](https://github.com/gradlex-org/extra-java-module-info#extra-java-module-info-gradle-plugin). This project demonstrates this.

This project uses shims.
They are availble at

- <https://github.com/koppor/wiremock-slf4j-spi-shim>
- <https://github.com/koppor/wiremock-slf4j-shim>
