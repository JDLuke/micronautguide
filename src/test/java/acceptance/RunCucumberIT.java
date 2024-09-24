package acceptance;

import io.cucumber.junit.Cucumber;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@MicronautTest
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/",
        glue="acceptance"
)
public class RunCucumberIT {
}
