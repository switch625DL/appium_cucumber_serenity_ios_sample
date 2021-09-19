package pages;

import helpers.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class NativeSystem {

    private IOSDriver driver;
    private WebDriverWait wait;
    private int alertWaitTime = 5;
    @FindBy(name = "Trust This Computer?")
    private MobileElement trustAlert;
    @FindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Settings\"]")
    private MobileElement systemSettingsHeader;
    @FindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Camera\"]")
    private MobileElement cameraSwitch;
    @FindBy(name = "Airplane Mode")
    private MobileElement airplaneModeSwitch;

    public NativeSystem(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, alertWaitTime);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void acceptTrustAlert() {
        int alertWaitTime = 10;
        WebDriverWait wait = new WebDriverWait(driver, alertWaitTime);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            wait.until(ExpectedConditions.visibilityOf(trustAlert));
            driver.switchTo().alert().accept();
            System.out.println("[LOG] Computer trusted.");
        } catch (Exception e) {
            System.out.println("[LOG] Could not accept trust alert. No alert present after " + alertWaitTime + " seconds. Proceeding with tests.");
        }
    }

    public void acceptSystemAlert() {
        int alertWaitTime = 5;
        WebDriverWait wait = new WebDriverWait(driver, alertWaitTime);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            System.out.println("[LOG] Dialog accepted.");
        } catch (Exception e) {
            System.out.println("[LOG] Could not accept alert. No alert present after " + alertWaitTime + " seconds. Proceeding with tests.");
        }
    }

    public void cancelSystemAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
            System.out.println("[LOG] Dialog dismissed.");
        } catch (Exception e) {
            System.out.println("[LOG] Could not dismiss alert. No alert present after " + alertWaitTime + " seconds. Proceeding with tests.");
        }
    }

    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    boolean isAlertDisplayed() {
        try {
            waitForAlert();
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException | TimeoutException e) {
            return false;
        }
    }

    public void onlyTapAcceptInSystemAlert() {
        driver.switchTo().alert().accept();
        System.out.println("[LOG] Camera permission granted.");
    }

    public void onlyTapDenyInSystemAlert() {
        driver.switchTo().alert().dismiss();
        System.out.println("[LOG] Camera permission denied");
    }
    public void openPhotoCookBookApp() {
        driver.launchApp();
    }

    public void takeScreenshot() {
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("Screenshot.jpg"));
        } catch (Exception e) {
            System.out.println("Failed to make screenshot.");
        }
    }
    public void minimizeAppForSeconds(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }
    public boolean areSystemSettingsDisplayed() {
        Helpers.waitForElement(systemSettingsHeader);
        return systemSettingsHeader.isDisplayed();
    }

    public boolean isAirplaneModeOff() {
        Helpers.waitForElement(airplaneModeSwitch);
        return airplaneModeSwitch.getAttribute("value").equals("0");
    }

    public void tapOnAirplaneModeSwitch() {
        airplaneModeSwitch.click();
    }

    public void openSystemSettings() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", "com.apple.Preferences");
        driver.executeScript("mobile: launchApp", args);
    }
    public boolean cameraSwitchIsActive() {
        return cameraSwitch.getAttribute("value").equals("1");
    }

    public void tapCameraSwitch() {
        cameraSwitch.click();
    }

    public void scrollToTheBottomOfSettings() {
        Helpers.longPressSwipe(150, 1120, 150, 200);
    }

    public void reopenSettings() {
        openSystemSettings();
    }

    public void killSystemSettingsInBackground() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", "com.apple.Preferences");
        driver.executeScript("mobile: terminateApp", args);
    }

    public void tapPoint(Integer x, Integer y) {
        Helpers.doubleTapByCoordinates(x, y);
    }

}