package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VehiclePage {

    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Permission Denied']")
    MobileElement deniedToast;
    @AndroidFindBy(id = "com.codecool.holabusz:id/testText")
    MobileElement meterText;
    @AndroidFindBy(id = "com.codecool.holabusz:id/seekBar")
    MobileElement meterSlider;
    @AndroidFindBy(id = "com.codecool.holabusz:id/recyclerView")
    MobileElement tableForVehicles;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
            "FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/" +
            "android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + listNumber + "]/android.widget.ImageView")
    MobileElement vehicleNumber;


}
