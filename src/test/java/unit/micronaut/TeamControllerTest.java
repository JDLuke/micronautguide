package unit.micronaut;

import example.micronaut.TeamConfiguration;
import example.micronaut.TeamController;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class TeamControllerTest {
    @Test
    void canCreate() {
        TeamConfiguration teamConfiguration = new TeamConfiguration();
        teamConfiguration.playerNames = List.of("name", "name2");
        teamConfiguration.name = "teamName";
        TeamController teamController = new TeamController(teamConfiguration);

        assertEquals("name, name2", teamController.teamPlayers());
        assertEquals("teamName", teamController.teamInfo());
    }
}
