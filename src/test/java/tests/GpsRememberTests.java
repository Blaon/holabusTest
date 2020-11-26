package tests;


import io.appium.java_client.android.Activity;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class GpsRememberTests extends Capabilities{


    @Test
    public void isOneTimePermissionButtonWork(){
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        driver.closeApp();
        driver.launchApp();
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        Assert.assertTrue(startPage.oneTimePermissionButton.isDisplayed());
    }

    @Test
    public void isPermissionAllTheTimeButtonWork(){
        wait.until(ExpectedConditions.visibilityOf(startPage.permissionAllTheTimeButton));
        startPage.clickOnAllTheTimeButton();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        driver.terminateApp("com.codecool.holabusz");
        driver.activateApp("com.codecool.holabusz");
        Assert.assertEquals("250m",vehiclePage.meterText.getText());
    }

    @Test
    public void isPermissionDenyButtonWork(){
        wait.until(ExpectedConditions.visibilityOf(startPage.denyPermissionButton));
        startPage.clickOnDeny();
        Assert.assertEquals("Permission Denied",vehiclePage.deniedToast.getText());
    }
}
