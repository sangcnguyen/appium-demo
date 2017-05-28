package libs;


import io.appium.java_client.android.AndroidDriver;
import objects.ContactPage;

/**
 * Created by Sang Nguyen on 5/28/2017.
 */

// ke thua lop cha ContactPage, hay noi cach khac mo rong tu lop ContactPage
public class ContactFuncs extends ContactPage {

    public ContactFuncs(AndroidDriver driver){
        // dc su dung de trieu hoi Contructor cua lop cha gan nhat
        super(driver);
    }

    public void addContact(String name,String phone){
        add_btn.clear();
        name_txt.sendKeys(name);
        phone_txt.sendKeys(phone);
        save_btn.click();
    }
}
