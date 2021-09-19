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

public class CookbooksScreen {

    private IOSDriver driver;

    @FindBy(name = "The Photo Cookbook")
    private List<MobileElement> cookbooksScreenHeader;




    public CookbooksScreen(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isCookbooksScreenHeaderDisplayed() {
        Helpers.waitForElementByCustomWait(cookbooksScreenHeader.get(0), 5);
        return cookbooksScreenHeader.get(0).isDisplayed();
    }
}
