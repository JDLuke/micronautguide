package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;


@Controller("/team")
public class TeamController {
    /**
     * Configuration for this team.
     */
    private final TeamConfiguration teamConfiguration;

    /**
     * @param config
     */
    public TeamController(final TeamConfiguration config) {
        this.teamConfiguration = config;
    }

    /**
     * @return The name of the team
     */
    @Get("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String teamInfo() {
        return teamConfiguration.getName();
    }

    /**
     * @return The players of the team in a CSV list
     */
    @Get("/players")
    @Produces(MediaType.TEXT_PLAIN)
    public String teamPlayers() {
        return String.join(", ", teamConfiguration.getPlayerNames());
    }
}
