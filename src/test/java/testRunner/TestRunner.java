package testRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/featureFiles/"},
        glue = {"stepsDefinitions"},
        //Format and directory of reports
        plugin = {"pretty", "html:target/cucumber"},
        tags = {"@sanity"}
)
public class TestRunner {
    @AfterClass
    public static void tearDown() {
        DriverFactory.getDriver().closeApp();
        DriverFactory.getDriver().quit();
    }
}
