package action;

import drivers.AndroidDriverManager;
import io.appium.java_client.AppiumBy;

public class AndroidAction {

  private AndroidAction() {
  }

  public static void scrollAndClick(String visibleText) {
    AndroidDriverManager.getDriver().findElement(AppiumBy.androidUIAutomator(
        ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
            + visibleText + "\").instance(0))"))).click();
  }
}
