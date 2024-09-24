package acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.response.Response;
import jakarta.inject.Inject;

import static io.restassured.RestAssured.*;

@MicronautTest
public class MyStepdefs {
    @Inject
    private MicronautObjectFactory objectFactory = new MicronautObjectFactory();

    @Inject
    private EmbeddedServer embeddedServer;

    @Given("The application has been started")
    public void theApplicationStarts() {
//        objectFactory.start();
        System.out.println(embeddedServer);
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response=get(endpoint);
    }

    @Then("The response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
        response.then().statusCode(arg0);

    }

    private Response response;
}
