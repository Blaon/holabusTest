package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ValidDataByDistance extends Capabilities {


    @ParameterizedTest
    @CsvFileSource(resources = "/dataFiles/gpsCoordinates.csv", numLinesToSkip = 1)
    public void availableVehiclesNumberByGPSCoordinates(Double lat, Double lon, String busNumber) {
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        setGPSCoordinates(lat, lon);
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.firstVehicleNumber));
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclePage.firstVehicleNumber, busNumber));
        Assert.assertEquals(vehiclePage.firstVehicleNumber.getText(), busNumber);
    }

    @Test
    public void isSliderWorking(){
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        setGPSCoordinates(47.5444, 19.0779);
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclePage.firstVehicleNumber, "120"));
        vehiclePage.setMeterSlider(0);
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.noStopsText));
        Assert.assertEquals(vehiclePage.noStopsText.getText(),vehiclePage.noStopsSentence);
    }

    @Test
    public void isSliderKeepMetersIfPhoneTurned(){
        wait.until(ExpectedConditions.visibilityOf(startPage.oneTimePermissionButton));
        startPage.clickOnOneTime();
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.meterText));
        vehiclePage.setMeterSlider(0.7);
        String distance = vehiclePage.meterText.getText();
        driver.rotate(new DeviceRotation(0,0,90));
        Assert.assertEquals(vehiclePage.meterText.getText(),distance);



    }
}
