package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Serdeable
@AllArgsConstructor
@NoArgsConstructor
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
     * @param teamName - String with the name of the team
     */
    public void setName(final String teamName) {
        this.name = teamName;
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
     * @param newColor - String containing the new color for the team.
     */
    public void setColor(final String newColor) {
        this.color = newColor;
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
     * @param newPlayerNames - A List of Strings containing all player names
     */
    public void setPlayerNames(final List<String> newPlayerNames) {
        this.playerNames = newPlayerNames;
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

