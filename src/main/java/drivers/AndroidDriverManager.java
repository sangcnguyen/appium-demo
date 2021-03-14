package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import server.AppiumServerProvider;
import utils.PropertyUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager {
    private AndroidDriverManager() {
    }

    private static final ThreadLocal<AndroidDriver<AndroidElement>> androidDriverTL = new ThreadLocal<>();

    public static void createDriver() {
        AndroidDriver<AndroidElement> androidDriver ;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("noReset", true);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyUtils.getParam("PLATFORM_NAME"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyUtils.getParam("PLATFORM_VERSION"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyUtils.getParam("DEVICE_NAME"));
        caps.setCapability("appPackage", PropertyUtils.getParam("APP_PACKAGE"));
        caps.setCapability("appActivity", PropertyUtils.getParam("APP_ACTIVITY"));
        caps.setCapability("noReset", true);
        try {
            androidDriver = new AndroidDriver<>(new URL(AppiumServerProvider.getAppiumServerAddress()), caps);
            androidDriverTL.set(androidDriver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return androidDriverTL.get();
    }

    public static void stopDriver() {
        androidDriverTL.get().quit();
        androidDriverTL.remove();
    }
}
