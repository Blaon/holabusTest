package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GpsRememberTests extends Capabilities{





    @Test
    public void isOneTimePermissionButtonWork(){
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        driver.closeApp();
        driver.launchApp();
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        Assert.assertTrue(startPage.oneTimePermissionButton.isDisplayed());
    }


}
