package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VisualClerificationTests extends Capabilities{



    @Test
    public void visualCheckOfZeroMeterScreen() throws Exception {
        String baseline = "zeroMeterImage";
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        setGPSCoordinates(47.5444, 19.0779);
        vehiclePage.setMeterSlider(0);
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.noStopsText));
        Assert.assertTrue(vehiclePage.doVisualCheck(baseline));
    }
}
