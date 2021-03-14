package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProfileScreen {
    public ProfileScreen(AndroidDriver<AndroidElement> androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//*[contains(concat(' ',@content-desc, ' '),' Call Mobile ')]//*[@resource-id='com.android.contacts:id/header']")
    private AndroidElement phoneText;

    @AndroidFindBy(xpath = "//*[contains(concat(' ',@content-desc, ' '),' Email Home ')]//*[@resource-id='com.android.contacts:id/header']")
    private AndroidElement emailText;


    @AndroidFindBy(id = "com.android.contacts:id/editor_menu_save_button")
    private AndroidElement saveBtn;

    public String getPhoneText() {
        return phoneText.getText();
    }

    public String getEmailText() {
        return emailText.getText();
    }
}
