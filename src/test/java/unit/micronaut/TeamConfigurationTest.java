package unit.micronaut;

import example.micronaut.TeamAdmin;
import example.micronaut.TeamConfiguration;
import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamConfigurationTest {
    @Test
    void testTeamConfigurationBuilder() {
        List<String> names = Arrays.asList("Nirav Assar", "Lionel Messi");
        Map<String, Object> items = new HashMap<>();
        items.put("team.name", "evolution");
        items.put("team.color", "green");
        items.put("team.team-admin.manager", "Jerry Jones");
        items.put("team.team-admin.coach", "Tommy O'Neill");
        items.put("team.team-admin.president", "Mark Scanell");
        items.put("team.player-names", names);

        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration.class);
        TeamAdmin teamAdmin = teamConfiguration.getBuilder().build();

        assertEquals("evolution", teamConfiguration.name);
        assertEquals("green", teamConfiguration.color);
        assertEquals("Nirav Assar", teamConfiguration.playerNames.get(0));
        assertEquals("Lionel Messi", teamConfiguration.playerNames.get(1));

        // check the builder has values set
        assertEquals("Jerry Jones", teamConfiguration.getBuilder().getManager());
        assertEquals("Tommy O'Neill", teamConfiguration.getBuilder().getCoach());
        assertEquals("Mark Scanell", teamConfiguration.getBuilder().getPresident());

        // check the object can be built
        assertEquals("Jerry Jones", teamAdmin.getManager());
        assertEquals("Tommy O'Neill", teamAdmin.getCoach());
        assertEquals("Mark Scanell", teamAdmin.getPresident());

        ctx.close();
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
