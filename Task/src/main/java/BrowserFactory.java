import framework.utils.ConfigManagerUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class BrowserFactory {
    private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);

    private BrowserFactory() {
    }

    protected static WebDriver createDriver() {
        String browserType = ConfigManagerUtil.getConfigData("browser").toUpperCase();

        switch (browserType) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();

                return new ChromeDriver(getChromeOptions());
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();

                return new FirefoxDriver(getFirefoxOptions());
            default:
                throw new RuntimeException("INCORRECT BROWSER NAME: " + browserType);
        }
    }

    public static WebDriver getDriver() {
        return Singleton.getDriver();
    }

    public static void killDriver() {
        log.info("Driver quit and null");
        Singleton.driverQuit();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> preferences = new HashMap<>();

        options.addArguments("window-size=" + ConfigManagerUtil.getConfigData("browser_width") + ","
                + ConfigManagerUtil.getConfigData("browser_height"));
        options.addArguments("ignore-certificate-errors");

        preferences.put("profile.default_content_settings.popups", Integer.parseInt(ConfigManagerUtil.getConfigData("chromePopups")));
        preferences.put("download.default_directory", System.getProperty("user.dir"));

        options.setExperimentalOption("prefs", preferences);

        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("-width", ConfigManagerUtil.getConfigData("browser_width"),
                "-height", ConfigManagerUtil.getConfigData("browser_height"));
        options.addPreference("browser.download.folderList", Integer.parseInt(ConfigManagerUtil.getConfigData("firefoxFolderList")));
        options.addPreference("browser.download.dir", System.getProperty("user.dir"));
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg");

        return options;
    }
}