package pages;


import helpers.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainScreen {

    private static String searchedRecipe;
    private static Color favRecipe;

    private IOSDriver driver;

    @FindBy(id = "Cookbooks")
    private MobileElement cookbooksButton;
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Quick & Easy\"]")
    private MobileElement quickAndEasyHeader;
    @FindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]")
    private MobileElement searchBar;
    @FindBy(id = "meat")
    private MobileElement meatCategory;
    @FindBy(id = "fish")
    private MobileElement fishCategory;
    @FindBy(id = "vegetarian")
    private MobileElement vegetarianCategory;
    @FindBy(id = "desserts")
    private MobileElement dessertsCategory;
    @FindBy(xpath = "XCUIElementTypeScrollView[1]")
    private MobileElement meatRecipesView;
    @FindBy(xpath = "XCUIElementTypeScrollView[2]")
    private MobileElement fishRecipesView;
    @FindBy(xpath = "XCUIElementTypeScrollView[3]")
    private MobileElement vegetarianRecipesView;
    @FindBy(xpath = "XCUIElementTypeScrollView[4]")
    private MobileElement dessertsRecipesView;
    @FindBy(id = "Search")
    private MobileElement search;
    @FindBy(id = "Clear text")
    private List<MobileElement> clearText;
    @FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeButton")
    private List<MobileElement> returnedSearchResults;
    @FindBy(xpath = "//dummyHeader")
    private MobileElement dummyHeader;
    @FindBy(xpath = "//dummyHeaderTwo")
    private MobileElement dummyHeaderTwo;
    @FindBy(xpath = "//dummyHeaderThree")
    private MobileElement dummyHeaderThree;





    public MainScreen(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public boolean isQuickAndEasyHeaderDisplayed() {
        Helpers.waitForElement(quickAndEasyHeader);
        return quickAndEasyHeader.isDisplayed();
    }

    public boolean isHeaderDisplayed() {
        Helpers.waitForElement(dummyHeader);
        return dummyHeader.isDisplayed();
    }

    public boolean isCookbooksButtonDisplayed() {
        Helpers.waitForElement(cookbooksButton);
        return cookbooksButton.isDisplayed();
    }

    public boolean areMainScreenHeadersDisplayed() {
        Helpers.waitForElement(meatCategory);
        Helpers.waitForElement(fishCategory);
        Helpers.waitForElement(vegetarianCategory);
        Helpers.waitForElement(dessertsCategory);
        return meatCategory.isDisplayed() && fishCategory.isDisplayed() && vegetarianCategory.isDisplayed() && dessertsCategory.isDisplayed();
    }

    public boolean isSearchBarEmpty() {
        return clearText.isEmpty();
    }

    public void enterWordInSearchInput(String name) {
        search.sendKeys(name);
    }

    public boolean areCorrectSearchResultsPresented() {
        System.out.println(returnedSearchResults.size());
        int i = returnedSearchResults.size();
        boolean b = i == 9;
        return b;
    }

    public void openSearchedRecipe(String name) {
        searchedRecipe = name;
        driver.findElementByName(searchedRecipe).click();
    }

    public void favoriteRecipe(String name) {
        searchedRecipe = name;
        Helpers.tapOffset((MobileElement) driver.findElementByName(searchedRecipe), 90, 90);
    }

    public boolean isRecipeFavorited() {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(src, new File("favorite.png"));
                BufferedImage compressedImage = ImageIO.read(new File("favorite.png"));
                Color currentColor = new Color(compressedImage.getRGB(180, 500));
//                System.out.println("LOG " + currentColor);
//                System.out.println("LOG " + favRecipe);
                return !currentColor.equals(favRecipe);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }

    public void tapCookbooksScreen() {
        cookbooksButton.click();
    }
}
