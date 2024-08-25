package example.micronaut;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("team")
public class TeamConfiguration {
    public String name;
    public String color;
    public List<String> playerNames;
}
