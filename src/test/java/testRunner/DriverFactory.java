package testRunner;


import helpers.Helpers;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    protected static IOSDriver driver;
    private static String appName;
    private String scenarioName;

    public static IOSDriver getDriver() {
        if (driver == null) {
            try {
                createDriver();
                System.out.println("[LOG] Driver created.");
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL Exception!");
            }
        }
        return driver;
    }

    private static void createDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPad Pro (11-inch)");
        capabilities.setCapability("platformVersion", "13.1");
        capabilities.setCapability("udid", "00008027-000D08A61AE8002E");
        capabilities.setCapability("bundleId", "net.ditter.FotoKochbuch");
        capabilities.setCapability("xcodeOrgId", "53T6FQDWV7");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("showXcodeLog", "true");

        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    public static void quit() {
        driver.quit();
    }
}
