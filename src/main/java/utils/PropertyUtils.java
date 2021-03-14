package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private PropertyUtils() {
    }

    public static String getParam(String param) {
        String path = "src/main/resources/config.properties";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        Properties prop = new Properties();
        // load properties file
        try (InputStream inputStream = new FileInputStream(absolutePath)) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(param);
    }
}
