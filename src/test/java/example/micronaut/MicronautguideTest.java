package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MicronautguideTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        assertTrue(application.isRunning());
    }

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    public void testHello() {
        HttpRequest<?> request = HttpRequest.GET("/hello").accept(MediaType.TEXT_PLAIN);
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        assertEquals("Hello World", body);
    }


    // @Test
    public void validateApplication() {
        Application application = new Application();

        Application.main(new String[0]);
    }
}
