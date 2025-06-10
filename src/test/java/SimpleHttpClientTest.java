// src/test/java/SimpleHttpClientTest.java
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleHttpClientTest {

    @RegisterExtension
    static WireMockExtension wm = WireMockExtension.newInstance().build();

    @Test
    void testGet() throws Exception {
        wm.stubFor(get("/test").willReturn(ok("Hello, WireMock!")));

        var client = new SimpleHttpClient();
        String result = client.get(wm.getRuntimeInfo().getHttpBaseUrl() + "/test");

        assertEquals("Hello, WireMock!", result);
    }
}
