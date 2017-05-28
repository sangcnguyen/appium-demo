package supports;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sang Nguyen on 5/28/2017.
 */
public class Settings {
        private static final String propFile = "./src/test/java/configurations/config.properties";
    // File src = new File(./src/test/java/configurations/config.properties);

    public static String getParam(String param) {
        Properties prop = new Properties();
        // load properties file
        try {
            InputStream inputStream = new FileInputStream(propFile);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(param);
    }

    public static int getTimeout(String param){
        Settings.getParam(param);
        return int getParam();
    }
}


