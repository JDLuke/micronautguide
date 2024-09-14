package com.jdluke.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HealthTest {
    @Inject
    @Client("/endpoints/")
    HttpClient client;

    @Test
    void testHealth() {
        HttpStatus status = client.toBlocking().retrieve(HttpRequest.GET("/health"), HttpStatus.class);
        assertEquals(HttpStatus.OK, status);
    }
}
