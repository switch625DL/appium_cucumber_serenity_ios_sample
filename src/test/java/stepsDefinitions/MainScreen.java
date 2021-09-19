package stepsDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import testRunner.DriverFactory;

public class MainScreen {
    private IOSDriver driver = DriverFactory.getDriver();
    private pages.MainScreen mainScreen = new pages.MainScreen(driver);

    public MainScreen() {
    }

    @When("^App is opened$")
    public void quickAndEasyHeaderIsDisplayed() {
        Assert.assertTrue("Header is not displayed!", mainScreen.isQuickAndEasyHeaderDisplayed());
    }

    @Then("^Main screen is displayed$")
    public void mainScreenIsDisplayed() {
        Assert.assertTrue("Header is not displayed!", mainScreen.isQuickAndEasyHeaderDisplayed());
        Assert.assertTrue("Cookbooks button is not displayed!", mainScreen.isCookbooksButtonDisplayed());
    }

    @Then("^Main screen is displayed properly$")
    public void mainScreenIsDisplayedProperly() {
        Assert.assertTrue("Main screen headers are not displayed!", mainScreen.areMainScreenHeadersDisplayed());
    }

    @Given("^Search bar is empty$")
    public void searchBarIsEmpty() {
        Assert.assertTrue("Search bar is not empty!", mainScreen.isSearchBarEmpty());
    }

    @When("^User inputs \"([^\"]*)\" into the search bar$")
    public void enterWordInSearchInput(String name) {
        mainScreen.enterWordInSearchInput(name);
    }

    @Then("^Recipes containing \"([^\"]*)\" are presented$")
    public void recipesContainingArePresented(String name) {
        driver.hideKeyboard();
        Assert.assertTrue("Incorrect search results are presented!", mainScreen.areCorrectSearchResultsPresented());
    }

    @When("^User opens \"([^\"]*)\" recipe$")
    public void userOpensRecipe(String name) {
        mainScreen.openSearchedRecipe(name);
    }

    @When("^User favorites \"([^\"]*)\" recipe$")
    public void userFavoritesRecipe(String name) {
        mainScreen.favoriteRecipe(name);
    }

    @Then("^Recipe is favorited$")
    public void recipeIsFavorited() {
        Assert.assertTrue("Recipe is not favorited!", mainScreen.isRecipeFavorited());
    }

    @When("^User opens Cookbooks screen$")
    public void userOpensCookbooksScreen() {
        mainScreen.tapCookbooksScreen();
    }
}
