package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;

public class SearchProductEndPoints extends BaseEndPoints{

    private final String SEARCH_PRODUCT_ENDPOINT_PATH = "/api/v1/search/demo";

    public String getPath() {
        return SEARCH_PRODUCT_ENDPOINT_PATH;
    }

    public Response getProductByName(String product, RequestSpecification rSpec) {

        rSpec = getCommonSpec().basePath(getBasePath(product));

        return sendRequest(rSpec, Constants.RequestType.GET_REQUEST);
    }

    private String getBasePath(String productName) {
        return String.format("%s/%s", getPath(), productName);
    }
}
