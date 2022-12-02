import framework.browserFactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame {
    public String name;
    public By locator;

    private static final Logger log = LoggerFactory.getLogger(Frame.class);

    public Frame(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public WebElement findFrame() {
        log.info("Frame: {}", name);

        return BrowserFactory.getDriver().findElement(locator);
    }
}