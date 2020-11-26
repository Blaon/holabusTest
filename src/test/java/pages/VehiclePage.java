package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.util.List;

public class VehiclePage extends CommonPage {


    public @AndroidFindBy(id = "com.codecool.holabusz:id/centerTextView")
    MobileElement noStopsText;
    public String noStopsSentence = "There are no stops available in 0 meters";
    public @AndroidFindBy(xpath = "//android.widget.Toast[@text='Permission Denied']")
    MobileElement deniedToast;
    public @AndroidFindBy(id = "com.codecool.holabusz:id/testText")
    MobileElement meterText;
    public @AndroidFindBy(id = "com.codecool.holabusz:id/seekBar")
    MobileElement meterSlider;
    public @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/" +
            "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/" +
            "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")
    MobileElement firstVehicleNumber;



    public VehiclePage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public int getNumberOfVehicles() {
        List<AndroidElement> vehicles = androidDriver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
        if (vehicles.size() < 1) {
            return 0;
        }
        return vehicles.size();
    }


    public void setMeterSlider(double percent) {
        int startX = meterSlider.getLocation().getX();
        int startY = meterSlider.getLocation().getY();
        int endX = meterSlider.getSize().getWidth();
        int moveToXDirectionAt = (int)(endX * percent);
        TouchAction act = new TouchAction(androidDriver);
        act.press(PointOption.point(startX, startY)).moveTo(PointOption.point(moveToXDirectionAt, startY)).release().perform();

    }

    public boolean doVisualCheck(String checkName) throws Exception {
    String baselineFileName = "C:\\Users\\ilove\\IdeaProjects\\holabusTest\\src\\test\\resources\\validationPictures\\"+checkName+".png";
    File baselineImg = new File(baselineFileName);
        System.out.println(baselineFileName);

    if (!baselineImg.exists()){
        System.out.printf("No baseline found for '%s' check capturing baseline!%n",checkName);
        File newBaseline = androidDriver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(newBaseline,new File(baselineFileName));
        return false;
    }
    SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
    opts.withEnabledVisualization();
    SimilarityMatchingResult res = androidDriver.getImagesSimilarity(baselineImg, androidDriver.getScreenshotAs(OutputType.FILE), opts);

    if(res.getScore()<0.99){
        File failViz = new File("C:\\Users\\ilove\\IdeaProjects\\holabusTest\\src\\test\\resources\\failedValidations\\"+checkName+".png");
        res.storeVisualization(failViz);
        return false;


    }
        System.out.println("Visual is passed!");
    return true;
    }
}

