package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Serdeable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties("builder")
@ConfigurationProperties("team")
public class TeamConfiguration {
    /**
     * Team name.
     */
    private String name;

    /**
     * @return String with name of team
     */
    public String getName() {
        return name;
    }
    /**
     * Team color.
     */
    private String color;

    /**
     * @return String with color of team
     */
    public String getColor() {
        return color;
    }

    /**
     * List of player names.
     */
    private List<String> playerNames;

    /**
     * @return List of player names
     */
    public List<String> getPlayerNames() {
        return playerNames;
    }

    /**
     * The actual builder object.
     */
    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    private TeamAdmin.Builder builder = new TeamAdmin.Builder();

    /**
     * @return a TeamAdmin.Builder
     */
    public TeamAdmin.Builder getBuilder() {
        return builder;
    }
}

