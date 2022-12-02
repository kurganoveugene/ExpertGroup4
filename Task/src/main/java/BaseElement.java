import framework.browserFactory.BrowserFactory;
import framework.utils.ConfigManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement {
    protected String name;
    protected By locator;

    private static final Logger log = LoggerFactory.getLogger(BaseElement.class);
    public final static int EXPLICIT_WAIT = Integer.parseInt(ConfigManagerUtil.getConfigData("explicitWait"));

    public BaseElement(String name, By locator) {
        log.info("Element: {}", name);

        this.name = name;
        this.locator = locator;
    }

    public void click() {
        log.info("Element: {}", name);

        BrowserFactory.getDriver().findElement(locator).click();
    }

    public String getText() {
        log.info("Element: {}", name);

        return BrowserFactory.getDriver().findElement(locator).getText();
    }

    public WebElement findElement() {
        log.info("Element: {}", name);

        return BrowserFactory.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        log.info("Element: {}", name);

        return BrowserFactory.getDriver().findElements(locator);
    }

    public void scrollToElement() {
        log.info("Element: {}", name);

        WebElement element = BrowserFactory.getDriver().findElement(locator);

        ((JavascriptExecutor) BrowserFactory.getDriver()).executeScript("arguments[0].scrollIntoView (true);", element);
    }

    public void visibilityOfElement() {
        log.info("Element: {}", name);

        new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void invisibilityOfElement() {
        log.info("Element: {}", name);

        new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public String getName() {
        log.info("Element: {}", name);

        return name;
    }

    public By getLocator() {
        log.info("Element: {}", name);

        return locator;
    }
}