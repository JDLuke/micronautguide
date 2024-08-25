package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/team")
public class TeamController {
    private final TeamConfiguration teamConfiguration;

    public TeamController(TeamConfiguration teamConfiguration) {
        this.teamConfiguration = teamConfiguration;
    }

    @Get("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String teamInfo() {
        return teamConfiguration.name;
    }
}
