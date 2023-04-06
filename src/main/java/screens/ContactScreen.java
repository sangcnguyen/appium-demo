package screens;

import action.AndroidAction;
import drivers.AndroidDriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactScreen {

  public ContactScreen() {
    PageFactory.initElements(
        new AppiumFieldDecorator(AndroidDriverManager.getDriver(), Duration.ofSeconds(30)), this);
  }

  @AndroidFindBy(id = "com.android.contacts:id/floating_action_button")
  public WebElement floatingBtn;

  @AndroidFindBy(xpath = "//*[@text='First name']")
  public WebElement firstNameInput;

  @AndroidFindBy(xpath = "//*[@text='Last name']")
  public WebElement lastNameInput;

  @AndroidFindBy(xpath = "//*[@text='Phone']")
  public WebElement phoneInput;

  @AndroidFindBy(xpath = "//*[@text='Email']")
  public WebElement emailInput;

  @AndroidFindBy(id = "com.android.contacts:id/editor_menu_save_button")
  public WebElement saveBtn;

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
