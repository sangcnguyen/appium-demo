package server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerProvider {

  private AppiumServerProvider() {
  }

  private static AppiumDriverLocalService appiumDriverLocalService;

  public static void startAppiumServer() {
    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
        .usingAnyFreePort()
        .withArgument(GeneralServerFlag.LOG_TIMESTAMP)
        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
        .withArgument(GeneralServerFlag.LOG_LEVEL, "info")
        .withArgument(GeneralServerFlag.RELAXED_SECURITY);

    appiumDriverLocalService = AppiumDriverLocalService.buildService(serviceBuilder);
    appiumDriverLocalService.start();
  }

  public static String getAppiumServerAddress() {
    return appiumDriverLocalService.getUrl().toString();
  }

  public static void stopAppiumServer() {
    appiumDriverLocalService.stop();
  }
}
