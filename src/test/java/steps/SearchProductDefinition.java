package steps;

import endpoints.SearchProductEndPoints;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import utils.ScenarioContext;
import static utils.ScenarioContext.API_RESPONSE;

public class SearchProductDefinition {

//    SearchProductEndPoints searchProductEndPoints = new SearchProductEndPoints();

    @Steps
    private SearchProductEndPoints searchProductEndPoints;

    @When("user performs the search product of {string}")
    public void SearchProduct(String product){
        ScenarioContext.set(API_RESPONSE, this.searchProductEndPoints.getProductByName(product,null));
    }


}
