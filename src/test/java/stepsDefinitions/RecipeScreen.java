package stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import testRunner.DriverFactory;

public class RecipeScreen {

    private IOSDriver driver = DriverFactory.getDriver();
    private pages.RecipeScreen recipeScreen = new pages.RecipeScreen(driver);

    public RecipeScreen() {
    }

    @Then("^A \"([^\"]*)\" recipe is opened$")
    public void isRecipeOpened(String name) {
//        recipeScreen.isRecipeOpened(name);
        Assert.assertTrue("Recipe is not opened!", recipeScreen.isRecipeOpened(name));
    }

}
