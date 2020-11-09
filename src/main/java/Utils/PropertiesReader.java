package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    static Properties properties;

    public PropertiesReader() {
         properties = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("Config.properties");
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public String getUrl() { return properties.getProperty("url"); }
        public String getFirstName () {
            return properties.getProperty("firstName");
        }
        public String getLastName () {
            return properties.getProperty("lastName");
        }
        public String getpostCode() {
            return properties.getProperty("postCode");
        }
        public int getWaitTimeOut() {
            return Integer.parseInt(properties.getProperty("waitTimeOut"));
        }

}
