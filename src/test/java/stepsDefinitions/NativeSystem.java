package stepsDefinitions;

        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import helpers.Helpers;
        import io.appium.java_client.ios.IOSDriver;
        import org.junit.Assert;
        import testRunner.DriverFactory;

        import java.util.HashMap;

public class NativeSystem {
    private IOSDriver driver = DriverFactory.getDriver();
    private pages.NativeSystem nativeSystem = new pages.NativeSystem(driver);

    public NativeSystem() {
    }

    @Given("^App is reopened$")
    public void reopenApp() {
        Helpers.reopenApp();
    }

    @Then("^Accept system alert if present$")
    public void acceptSystemAlert() {
        nativeSystem.acceptSystemAlert();
    }

    @Then("^Cancel system alert if present$")
    public void cancelSystemAlert() {
        nativeSystem.cancelSystemAlert();
    }

    @Given("^Quit application$")
    public void forceQuitApplication() {
        driver.closeApp();
    }

    @And("^Open application$")
    public void openApplication() {
        driver.launchApp();
    }

    @Given("^Reopen application$")
    public void reopenApplication() {
        driver.closeApp();
        driver.launchApp();
    }

    @And("^Sleep$")
    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^Wait for trust popup and accept it if present$")
    public void waitForTrustPopupAndAcceptItIfPresent() {
        nativeSystem.acceptTrustAlert();
    }

    @Given("^Take screenshot$")
    public void takeScreenshot() {
        nativeSystem.takeScreenshot();
    }


    @When("^Minimize app for \"([^\"]*)\" seconds$")
    public void minimizeAppForSeconds(int seconds) {
        nativeSystem.minimizeAppForSeconds(seconds);
    }

    @Then("^System settings are displayed$")
    public void systemSettingsAreDisplayed() {
        Assert.assertTrue("System settings are not displayed!", nativeSystem.areSystemSettingsDisplayed());
    }

    @And("^Airplane mode switch is off$")
    public void airplaneModeSwitchIsOff() {
        Assert.assertTrue("Airplane mode is on!", nativeSystem.isAirplaneModeOff());
    }

    @When("^Tap on Airplane mode switch$")
    public void tapOnAirplaneModeSwitch() {
        nativeSystem.tapOnAirplaneModeSwitch();
    }

    @And("^Airplane mode switch is on$")
    public void airplaneModeSwitchIsOn() {
        Assert.assertFalse("Airplane mode is off!", nativeSystem.isAirplaneModeOff());
    }

    @When("^Send app \"([^\"]*)\" to background$")
    public void sendAppToBackground(String bundleId) {
        driver.terminateApp(bundleId);
    }

    @And("^Open system settings$")
    public void openSystemSettings() {
        nativeSystem.openSystemSettings();
    }

    @Given("^Maximize \"([^\"]*)\" app$")
    public void maximizeApp(String bundleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", bundleId);
        driver.executeScript("mobile: activateApp", args);
    }

    @When("^Scroll to bottom of settings$")
    public void scrollToBottomOfSettings() {
        nativeSystem.scrollToTheBottomOfSettings();
    }

    @And("^Camera switch is not active$")
    public void cameraSwitchIsNotActive() {
        Assert.assertFalse("Camera switch is active!", nativeSystem.cameraSwitchIsActive());
    }

    @When("^Tap on camera switch$")
    public void tapOnCameraSwitch() {
        nativeSystem.tapCameraSwitch();
    }

    @Then("^Camera switch is active$")
    public void cameraSwitchIsActive() {
        Assert.assertTrue("Camera switch is not active!", nativeSystem.cameraSwitchIsActive());
    }

    @And("^Reopen settings$")
    public void reopenSettings() {
        nativeSystem.reopenSettings();
    }

    @And("^Kill system settings in background$")
    public void killSystemSettingsInBackground() {
        nativeSystem.killSystemSettingsInBackground();
    }

    @When("^Tap point x \"([^\"]*)\" y \"([^\"]*)\"$")
    public void tapPointXY(Integer x, Integer y) {
        nativeSystem.tapPoint(x, y);
    }
}
