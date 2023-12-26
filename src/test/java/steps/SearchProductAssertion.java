package steps;

import endpoints.model.ProductDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import org.junit.Assert;
import utils.ScenarioContext;

import java.util.List;

public class SearchProductAssertion {

    @Then("the search result contains product items")
    public void callSearchProduct(DataTable productTable) {

        List<ProductDTO> actualProducts = ScenarioContext.getApiResponse()
                .getBody().as(new TypeRef<List<ProductDTO>>() {
                });

        productTable.asMaps().forEach(product -> {
            Assert.assertTrue("Product is not present" + product.toString(),
                    actualProducts.stream().anyMatch(p ->
                            p.getTitle().trim().equalsIgnoreCase(product.get("title").trim()) &&
                                    p.getPrice() == Double.parseDouble(product.get("price").trim()) &&
                                    p.getBrand().trim().equalsIgnoreCase(product.get("brand").trim()) &&
                                    p.isPromo() == Boolean.parseBoolean(product.get("isPromo").trim())
                    ));
        });
    }
}
