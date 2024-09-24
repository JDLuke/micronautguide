package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Serdeable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties("builder")
@ConfigurationProperties("team")
public class TeamConfiguration {
    public String name;
    public String color;
    public List<String> playerNames;

//    @Getter
    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    TeamAdmin.Builder builder = new TeamAdmin.Builder();

//    @Getter
    public TeamAdmin.Builder getBuilder() {
        return builder;
    }
}

