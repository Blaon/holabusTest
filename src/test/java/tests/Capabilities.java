package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Capabilities {
    int waitTime = 10;
    AndroidDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, waitTime);

    @BeforeTest
    public void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86_arm");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\ilove\\IdeaProjects\\holabusTest\\src\\test\\resources\\apps\\HolabuszLite.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,"false");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,"true");
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        assert url != null;
        driver = new AndroidDriver(url, capabilities);
    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
