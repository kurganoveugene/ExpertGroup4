import framework.browserFactory.BrowserFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitManagerUtil {

    public static void waitForFileDownloaded(String downloadPath, String fileName) {

    Wait<WebDriver> wait = new FluentWait<>(BrowserFactory.getDriver())
            .withTimeout(Duration.ofSeconds(30L))
            .pollingEvery(Duration.ofSeconds(5L))
            .ignoring(NoSuchElementException.class);

    wait.until((WebDriver) -> FileSearcher.isFileDownloaded(downloadPath, fileName));
    }
}