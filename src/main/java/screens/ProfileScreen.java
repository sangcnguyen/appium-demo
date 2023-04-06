package screens;

import drivers.AndroidDriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfileScreen {

  public ProfileScreen() {
    PageFactory.initElements(
        new AppiumFieldDecorator(AndroidDriverManager.getDriver(), Duration.ofSeconds(30)), this);
  }

  @AndroidFindBy(xpath = "//*[contains(concat(' ',@content-desc, ' '),' Call Mobile ')]//*[@resource-id='com.android.contacts:id/header']")
  public WebElement phoneText;

  @AndroidFindBy(xpath = "//*[contains(concat(' ',@content-desc, ' '),' Email Home ')]//*[@resource-id='com.android.contacts:id/header']")
  public WebElement emailText;

  public String getPhoneText() {
    return phoneText.getText();
  }

  public String getEmailText() {
    return emailText.getText();
  }
}
