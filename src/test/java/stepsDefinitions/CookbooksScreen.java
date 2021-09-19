package stepsDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import testRunner.DriverFactory;

public class CookbooksScreen {
    private IOSDriver driver = DriverFactory.getDriver();
    private pages.CookbooksScreen cookbooksScreen = new pages.CookbooksScreen(driver);

    public CookbooksScreen(){
    }


    @When("^Cookbooks screen is displayed$")
    public void cookbooksScreenHeaderIsDisplayed() {
        Assert.assertTrue("Header is not displayed!", cookbooksScreen.isCookbooksScreenHeaderDisplayed());
    }


}
