package acceptance;

import example.micronaut.Application;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class MyStepdefs {

    @Given("The application has been started")
    public void theApplicationStarts() {
        Application.main(new String[]{});
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
