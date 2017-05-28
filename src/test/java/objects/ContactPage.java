package objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBySet;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Sang Nguyen on 5/28/2017.
 */
public class ContactPage {
    public AndroidDriver driver;

    public ContactPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id="com.android.contacts:id/floating_action_button")
    public AndroidElement add_btn; // MobileElement

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Name']")
    public AndroidElement name_txt;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
    public AndroidElement phone_txt;

    @AndroidFindBy(id="com.android.contacts:id/menu_save")
    public AndroidElement save_btn;

    @AndroidFindBy(id="com.android.contacts:id/menu_search")
    public AndroidElement search_btn;

    @AndroidFindBy(id="com.android.contacts:id/search_view")
    public AndroidElement search_txt;

    @AndroidFindBy(id = "com.android.contacts:id/cliv_name_textview")
    public AndroidElement click_txt;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='More options']")
    public AndroidElement option_btn;

//    @AndroidFindAll(id="android:id/title")
    public final String OPTION_MENU="android:id/title";

//    public List<AndroidElement> option_mn= driver.findElements(By.id(OPTION_MENU));

    /*
    public void addContact(String name, String phone){
        add_btn.clear();
        name_txt.sendKeys(name);
        phone_txt.sendKeys(phone);
        save_btn.click();
    }
    */

    public  void deleteContact(String searchKey){
        search_btn.click();
        search_txt.sendKeys(searchKey);
        click_txt.click();
        option_btn.click();
        selectMenu("Delete");
    }

    public void selectMenu (String option){
        List<AndroidElement> option_mn= driver.findElements(By.id(OPTION_MENU));
        for(AndroidElement ele:option_mn){
            if(ele.getText().equalsIgnoreCase(option)){
                ele.click();
                break;
            }
        }
    }

}
