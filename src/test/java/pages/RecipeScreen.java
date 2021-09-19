package pages;

import helpers.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testRunner.DriverFactory;

import java.util.List;


public class RecipeScreen {

    private static String openedRecipe;

    private IOSDriver driver;

    @FindBy(name = "ginger baked alaskas")
    private List<MobileElement> gbaRecipe;




    public RecipeScreen(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isRecipeOpened(String name) {
        openedRecipe = name;
        String s = driver.findElementByName(openedRecipe).getAttribute("name");
        return s.equals(openedRecipe);
    }
}
