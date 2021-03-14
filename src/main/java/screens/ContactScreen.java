package screens;

import action.AndroidAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ContactScreen {
    public ContactScreen(AndroidDriver<AndroidElement> androidDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver, Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(id = "com.android.contacts:id/floating_action_button")
    private AndroidElement floatingBtn;

    @AndroidFindBy(xpath = "//*[@text='First name']")
    private AndroidElement firstNameInput;

    @AndroidFindBy(xpath = "//*[@text='Last name']")
    private AndroidElement lastNameInput;

    @AndroidFindBy(xpath = "//*[@text='Phone']")
    private AndroidElement phoneInput;

    @AndroidFindBy(xpath = "//*[@text='Email']")
    private AndroidElement emailInput;


    @AndroidFindBy(id = "com.android.contacts:id/editor_menu_save_button")
    private AndroidElement saveBtn;

    public void addContact(String firstName, String lastName, String phone, String email) {
        floatingBtn.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        phoneInput.sendKeys(phone);
        AndroidAction.scrollAndClick("Email");
        emailInput.sendKeys(email);
        saveBtn.click();
    }
}
