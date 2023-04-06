package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import server.AppiumServerProvider;
import utils.PropertyUtils;

public class AndroidDriverManager {

  private AndroidDriverManager() {
  }

  private static final ThreadLocal<AndroidDriver> androidDriverTL = new ThreadLocal<>();

  public static void createDriver() {
    // create caps
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName(PropertyUtils.getParam("PLATFORM_NAME"));
    options.setPlatformVersion(PropertyUtils.getParam("PLATFORM_VERSION"));
    options.setNoReset(true);
    options.setDeviceName(PropertyUtils.getParam("DEVICE_NAME"));
    options.setAppPackage(PropertyUtils.getParam("APP_PACKAGE"));
    options.setAppActivity(PropertyUtils.getParam("APP_ACTIVITY"));

    AndroidDriver androidDriver;
    try {
      androidDriver = new AndroidDriver(new URL(AppiumServerProvider.getAppiumServerAddress()),
          options);
      androidDriverTL.set(androidDriver);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public static AndroidDriver getDriver() {
    return androidDriverTL.get();
  }

  public static void stopDriver() {
    androidDriverTL.get().quit();
    androidDriverTL.remove();
  }
}
