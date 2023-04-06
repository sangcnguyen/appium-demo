import drivers.AndroidDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import server.AppiumServerProvider;

public class BaseTest {

  @BeforeSuite
  public void startAppiumServer() {
    AppiumServerProvider.startAppiumServer();
  }

  @BeforeClass
  public void startDriver() {
    AndroidDriverManager.createDriver();
  }

  @AfterClass
  public void stopDriver() {
    AndroidDriverManager.stopDriver();
  }

  @AfterSuite
  public void stopAppiumServer() {
    AppiumServerProvider.stopAppiumServer();
  }
}
