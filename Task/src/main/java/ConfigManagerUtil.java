import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManagerUtil {
    private static final Properties CONFIGDATA = new Properties();
    private static final Properties TESTDATA = new Properties();
    private static final Properties USERDATA = new Properties();
    private static final Properties LOG4JCONFIG = new Properties();

    private static final Logger log = LoggerFactory.getLogger(ConfigManagerUtil.class);

    private ConfigManagerUtil() {
    }

    static {
        loadConfigData();
        loadTestData();
        loadLog4jConfig();
    }

    private static void loadConfigData() {
        try (
                InputStream configInputStream = ConfigManagerUtil.class.getClassLoader().getResourceAsStream("configData.properties");
        ) {
            CONFIGDATA.load(configInputStream);
        } catch (IOException e) {
            log.error("Unable to read config data file {}", e);

            throw new RuntimeException(e);
        }
    }

    private static void loadTestData() {
        try (
            InputStream testDataInputStream = ConfigManagerUtil.class.getClassLoader().getResourceAsStream("testData.properties")
        ) {
            TESTDATA.load(testDataInputStream);
        } catch (IOException e) {
            log.error("Unable to read test data file {}", e);

            throw new RuntimeException(e);
        }
    }

    private static void loadLog4jConfig() {
        try (
                InputStream log4jConfigInputStream = ConfigManagerUtil.class.getClassLoader().getResourceAsStream("log4j.properties")
        ) {
            LOG4JCONFIG.load(log4jConfigInputStream);
        } catch (IOException e) {
            log.error("Unable to read log4j config file {}", e);

            throw new RuntimeException(e);
        }
    }

    public static String getConfigData(String key) {
        log.info("");

        return CONFIGDATA.getProperty(key);
    }

    public static String getTestData(String key) {
        log.info("");

        return TESTDATA.getProperty(key);
    }
}