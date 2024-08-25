package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.context.ApplicationContext;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    void testTeamConfiguration() {
        List<String> names = Arrays.asList("Nirav Assar", "Lionel Messi");

        Map<String, Object> items = new HashMap<>();
        items.put("team.name", "evolution");
        items.put("team.color", "green");
        items.put("team.player-names", names);

        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration.class);

        assertEquals("evolution", teamConfiguration.name);
        assertEquals("green", teamConfiguration.color);
        assertEquals(names.size(), teamConfiguration.playerNames.size());
        names.forEach(name -> assertTrue(teamConfiguration.playerNames.contains(name)));

        ctx.close();
    }
}
