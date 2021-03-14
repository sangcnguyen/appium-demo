package action;

import drivers.AndroidDriverManager;

public class AndroidAction {
    private AndroidAction() {
    }

    public static void scrollAndClick(String visibleText) {
        AndroidDriverManager.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }
}
