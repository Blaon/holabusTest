package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import tests.Capabilities;

import java.util.List;

public class VehiclePage extends CommonPage{

    Capabilities capabilities = new Capabilities();

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Permission Denied']")
    MobileElement deniedToast;
    @AndroidFindBy(id = "com.codecool.holabusz:id/testText")
    MobileElement meterText;
    @AndroidFindBy(id = "com.codecool.holabusz:id/seekBar")
    MobileElement meterSlider;
    @AndroidFindBy(id = "com.codecool.holabusz:id/recyclerView")
    MobileElement tableForVehicles;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "android.view.ViewGroup[1]/android.widget.TextView[1]")
    MobileElement firstVehicleNumber;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "android.view.ViewGroup[1]/android.widget.TextView[4")
    MobileElement firstVehicleTimeOfArrival;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
            "android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/" +
            "android.view.ViewGroup[1]/android.widget.TextView[2]")
    MobileElement getFirstVehicleDestination;

    public VehiclePage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public int getNumberOfVehicles(){
        int numberOfVehicles;
        List<AndroidElement> elements = capabilities.driver.findElements(MobileBy.xpath("//recyclerView/*"));
        numberOfVehicles = elements.size();
        if (numberOfVehicles<1){
            return 0;
        }
        return numberOfVehicles;
    }

    public void setMeterSlider(String meter){
        meterSlider.sendKeys(meter);
}
}

