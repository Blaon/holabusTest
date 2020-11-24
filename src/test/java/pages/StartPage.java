package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartPage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    MobileElement permissionAllTheTimeButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    MobileElement oneTimePermissionButton;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
    MobileElement denyPermissionButton;

    public void clickOn(MobileElement element){
        element.click();
    }
}
