package steps;


import io.cucumber.java.en.Then;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import utils.ScenarioContext;

import static org.hamcrest.Matchers.is;

public class CommonSteps {

    @Then("response has {int} status code")
    public void verifyResponseStatusCode(int expectedStatusCode){
      ScenarioContext.getApiResponse().then().assertThat().statusCode(expectedStatusCode);

    }

    @Then("response contains an error {string}")
    public void verifyResponseErrorMessage(String expectedErrorMessage) {

        ScenarioContext.getApiResponse().then().assertThat()
                .body("detail.error", Is.is(true));
        ScenarioContext.getApiResponse().then().assertThat()
                .body("detail.message", Is.is(expectedErrorMessage));

    }

    @Then("the user sees empty product details response body")
    public void theUserSeesEmptyProductDetailsResponseBody() {

        ScenarioContext.getApiResponse().then().assertThat().statusCode(HttpStatus.SC_OK);
        MatcherAssert.assertThat("Response body was not empty!",ScenarioContext.getApiResponse().asString(),is("[]"));

    }
}
