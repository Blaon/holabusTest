package tests;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class GpsRememberTests extends Capabilities{
    StartPage startPage = new StartPage();

    @Test
    void isOneTimePermissionButtonWork(){
        System.out.println(oneTimePermissionButton);
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        driver.closeApp();
        driver.launchApp();
        Assert.assertFalse(startPage.oneTimePermissionButton.isDisplayed());
    }
}
