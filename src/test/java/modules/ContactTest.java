package modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import libs.ContactFuncs;
import objects.ContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.AndroidCommonFuctions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sang Nguyen on 5/28/2017.
 */
public class ContactTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp(){
        AndroidCommonFuctions.openApp();
    }

    @Test
    public void addContact(){
        // day session tu tren driver xuong
        ContactFuncs contactFuncs = new ContactFuncs(driver);
        //contactPage.deleteContact("Auto");
        contactFuncs.addContact("Buto","19001018");

    }

    @Test


    @AfterTest
    public void tearDown(){
        driver.closeApp();
    }

}
