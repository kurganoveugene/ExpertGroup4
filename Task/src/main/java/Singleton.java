import org.openqa.selenium.WebDriver;

public class Singleton {
    private static WebDriver driver = null;

    private Singleton() {
    }

    protected static WebDriver getDriver() {

        if (driver == null) {
            driver = BrowserFactory.createDriver();
        }

        return driver;
    }

    protected static void driverQuit() {
        driver.quit();

        driver = null;
    }
}