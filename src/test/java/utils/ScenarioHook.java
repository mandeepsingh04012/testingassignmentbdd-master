package utils;

import io.cucumber.java.After;

/**
 * ScenarioHook implements Cucumber 'after' scenario hook to clear the scenario context
 */

public class ScenarioHook {
    @After
    public void clearScenarioContext(){
        ScenarioContext.clear();
    }
}
