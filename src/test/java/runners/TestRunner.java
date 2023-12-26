package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(monochrome = true,
        plugin = {"pretty"},
        glue ="steps",
        tags="@smokeTest",
        features = "src/test/resources/features"

)
public class TestRunner {}
