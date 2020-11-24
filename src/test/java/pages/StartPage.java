package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartPage {

    public @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    MobileElement permissionAllTheTimeButton;
    public @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    MobileElement oneTimePermissionButton;
    public @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
    MobileElement denyPermissionButton;

    public void clickOnAllTheTimeButton() {
        permissionAllTheTimeButton.click();
    }

    public void clickOnOneTime() {
        oneTimePermissionButton.click();
    }

    public void clickOnDeny() {
        denyPermissionButton.click();
    }
}
