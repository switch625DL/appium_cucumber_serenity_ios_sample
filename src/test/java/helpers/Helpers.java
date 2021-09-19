package helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import pages.

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static io.appium.java_client.touch.offset.PointOption.point;


public class Helpers {

    private static IOSDriver driver = testRunner.DriverFactory.getDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 20);
    private static WebDriverWait shortWait = new WebDriverWait(driver, 5);

    public static void resetApp() {
        driver.closeApp();
        driver.launchApp();
    }

    public static void waitForElement(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void reopenApp() {
        driver.closeApp();
        driver.launchApp();
    }

    /**
     * Swipe method that swipes from point a (aX, aY)
     * to point b (bX, bY). Pass coordinates in the given order.
     */
    public static void swipe(int startX, int startY, int endX, int endY) {
        PointOption start = new PointOption().withCoordinates(startX, startY);
        PointOption end = new PointOption().withCoordinates(endX, endY);

        TouchAction swipe = new TouchAction(driver);
        swipe.press(start).moveTo(end).release().perform();
    }

    public static void swipeJS(String direction) {
        JavascriptExecutor js = driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: swipe", scrollObject);
    }

    public static void longPressSwipe(int startX, int startY, int endX, int endY) {
        PointOption start = new PointOption().withCoordinates(startX, startY);
        PointOption end = new PointOption().withCoordinates(endX, endY);

        TouchAction swipe = new TouchAction(driver);
        swipe.longPress(start).moveTo(end).release().perform();
    }

    public static boolean waitUntilElementNotVisible(MobileElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void sendKeysToMobileElement(MobileElement element, String keysToSend) {
        element.sendKeys(keysToSend);
    }

    public static void tapMobileElementIfAvailable(MobileElement element) {
        if (!element.isEnabled()) {
            Helpers.waitForElement(element);
        } else if (element.isEnabled()) {
            element.click();
        }
    }

    public static void tapMobileElementByName(String elementName) {
        MobileElement element = (MobileElement) driver.findElement(By.name(elementName));
        element.click();
    }

    public static void sendKeysToMobileElementByName(String elementName, String text) {
        MobileElement element = (MobileElement) driver.findElement(By.name(elementName));
        element.sendKeys(text);
    }

    public static void tapScreenByCoordinates(int xOffset, int yOffset) {
        TouchAction singleTap = new TouchAction(driver);
        singleTap.tap(point(xOffset, yOffset));
    }

    public static void tapScreenByCoordinatesMultipleTimes(int xOffset, int yOffset, int howManyTimes) {
        TouchAction singleTap = new TouchAction(driver);
        do {
            singleTap.tap(point(xOffset, yOffset));
            howManyTimes--;
        } while (howManyTimes > 0);
    }

    public static void longTapOnMobileElement(MobileElement element) {
        TouchAction longTap = new TouchAction(driver);
        int leftX = element.getLocation().getX() + 10;
        int middleY = element.getCenter().y;
        longTap.longPress(point(leftX, middleY)).perform();
    }

    public static void doubleTapByCoordinates(int xOffset, int yOffset) {
        TouchAction doubleTap = new TouchAction(driver);
        doubleTap.press(point(xOffset, yOffset)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(50))).release().perform();
        doubleTap.press(point(xOffset, yOffset)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(50))).release().perform();
    }

    public static List<Integer> getCenterOfMobileElement(MobileElement element) {
        List<Integer> coordinatesList = new ArrayList<Integer>();
        coordinatesList.add(element.getLocation().getX() + (element.getSize().getWidth()) / 2);
        coordinatesList.add(element.getLocation().getY() + (element.getSize().getHeight()) / 2);
        return coordinatesList;
    }

    public static void waitForElementByCustomWait(MobileElement element, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, secondsToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void tapElement(MobileElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }
    public static void tapOffset(MobileElement element, int xOffsetPercentage, int yOffsetPercentage) {
        TouchAction action = new TouchAction(driver);
        int x = element.getLocation().x;
        int xElemWidth = element.getSize().width;
        System.out.println(xElemWidth);
        int y = element.getLocation().y;
        int yElemWidth = element.getSize().height;
        System.out.println(yElemWidth);
        int xOffset = x + ((xElemWidth * xOffsetPercentage) / 100);
        System.out.println(xOffset);
        int yOffset = y + ((yElemWidth * yOffsetPercentage) / 100);
        System.out.println(yOffset);
        action.press(point(xOffset, yOffset))
                .release()
                .perform();
    }
    public static MobileElement getVisibleElementFromList(List<MobileElement> list) {
        for (MobileElement element : list) {
            try {
                if (element.isDisplayed()) {
                    return element;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
}
