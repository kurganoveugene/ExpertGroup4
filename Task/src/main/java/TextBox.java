import framework.baseElement.BaseElement;
import framework.browserFactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextBox extends BaseElement {
    private static final Logger log = LoggerFactory.getLogger(TextBox.class);

    public TextBox(String name, By locator) {
        super(name, locator);
    }

    public void sendKeys(String value) {
        log.info("TextBox name: {}", name);

        WebElement textBox = BrowserFactory.getDriver().findElement(locator);

        textBox.sendKeys(value);
    }

    public void sendEnter() {
        log.info("TextBox name: {}", name);

        WebElement textBox = BrowserFactory.getDriver().findElement(locator);

        textBox.sendKeys(Keys.ENTER);
    }
}