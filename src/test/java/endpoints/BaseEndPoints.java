package endpoints;

import env.ApplicationProperties;
import env.Environment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utils.Constants;

public class BaseEndPoints {

    ApplicationProperties appProps = Environment.INSTANCE.getApplicationProperties();

    /**
     *  common specification for request
     */

    public RequestSpecification getCommonSpec() {
        RequestSpecification rSpec = SerenityRest.given();
        rSpec.contentType(ContentType.JSON).baseUri(appProps.getBaseURL());
        return rSpec;
    }

    /**
     * Verify that the response code is the same as expected code by comparing the
     * provided expected code and the response code from the response received by
     * sending the request
     */
    public void verifyResponseStatusCode(Response response, int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode);
    }

    /**
     * Send request
     *
     * @param request     details for sending the request
     * @param requestType of the request. i.e GET, POST, PUT, DELETE, UPDATE
     * @return response received from the service by sending the request
     */


    public Response sendRequest(RequestSpecification request, String requestType) {
        Response response;

        // need to add a switch based on request type
        switch (requestType) {
            case Constants.RequestType.GET_REQUEST:
            default:
                if (request == null) {
                    response = SerenityRest.when().get();
                } else {
                    response = request.get();
                }
                break;
        }
        return response;
    }
}
