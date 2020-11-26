package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.StartPage;
import pages.VehiclePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {
    int waitTime = 16;
    public static AndroidDriver<AndroidElement> driver;
    public static WebDriverWait wait;
    StartPage startPage;
    VehiclePage vehiclePage;


    @Before
    @BeforeEach
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86_arm");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ilove\\IdeaProjects\\holabusTest\\src\\test\\resources\\apps\\HolabuszLite.apk");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,"true");
        capabilities.setCapability("resetOnSessionStartOnly","true");



        capabilities.setCapability("appPackage","com.codecool.holabusz");
        capabilities.setCapability("appActivity",".SplashActivity");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert url != null;

        driver = new AndroidDriver<>(url, capabilities);

        wait = new WebDriverWait(driver, waitTime);
        startPage = new StartPage(driver);
        vehiclePage = new VehiclePage(driver);


    }

    public void setGPSCoordinates(Double latitude,Double longitude){
        driver.setLocation(new Location(latitude,longitude,0));
    }



    @After
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
