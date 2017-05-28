package supports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sang Nguyen on 5/28/2017.
 */
public class AndroidCommonFuctions {

    public static AndroidDriver openApp(){
        AndroidDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("noReset",true);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,Settings.getParam("PLATFORM_NAME"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, Settings.getParam("PLATFORM_VERSION"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,Settings.getParam("DEVICE_NAME"));
        caps.setCapability("appPackage",Settings.getParam("APP_PACKAGE"));
        caps.setCapability("appActivity",Settings.getParam("APP_ACTIVITY"));
        try {
            driver = new AndroidDriver(new URL(Settings.getParam("APP_HOST")),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void swipe(){

    }

    public static void scroll(){

    }

    public static void spinner(){

    }

    public static void captureScreenshot(){

    }

    public static void pressHome(){

    }

    public static void pressMenu(){

    }

    public static void pressBack(){

    }

    public static void switchApp(){

    }
}
