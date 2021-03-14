import drivers.AndroidDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.ContactScreen;
import screens.ProfileScreen;

public class ContactTest extends BaseTest {

    @Test
    public void addContact() {
        ContactScreen contactScreen = new ContactScreen(AndroidDriverManager.getDriver());
        ProfileScreen profileScreen = new ProfileScreen(AndroidDriverManager.getDriver());
        contactScreen.addContact("sang", "nguyen", "1321", "thisemaildoesnotexist@gmail.com");
        Assert.assertEquals(profileScreen.getPhoneText(), "1 321");
        Assert.assertEquals(profileScreen.getEmailText(), "thisemaildoesnotexist@gmail.com");
    }
}
