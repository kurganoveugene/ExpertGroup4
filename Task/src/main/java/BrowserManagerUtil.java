import framework.baseElement.BaseElement;
import framework.browserFactory.BrowserFactory;
import framework.frame.Frame;
import org.openqa.selenium.NoAlertPresentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserManagerUtil {
    private static final Logger log = LoggerFactory.getLogger(BrowserManagerUtil.class);

    private BrowserManagerUtil() {
    }

    public static void openPage(String url) {
        log.info("");

        BrowserFactory.getDriver().get(url);
    }

    public static String getAlertText() {
        log.info("");

        return BrowserFactory.getDriver().switchTo().alert().getText();
    }

    public static void acceptAlert() {
        log.info("");

        BrowserFactory.getDriver().switchTo().alert().accept();
    }

    public static boolean isAlertExist() {
        log.info("");

        try {
            BrowserFactory.getDriver().switchTo().alert();
        } catch (NoAlertPresentException e) {
            return false;
        }

        return true;
    }

    public static void sendKeysToAlert(String text) {
        log.info("");

        BrowserFactory.getDriver().switchTo().alert().sendKeys(text);

        acceptAlert();
    }

    public static void switchToFrame(Frame frame) {
        log.info("");

        BrowserFactory.getDriver().switchTo().frame(frame.findFrame());
    }

    public static void quitFrames() {
        log.info("");

        BrowserFactory.getDriver().switchTo().defaultContent();
    }

    public static void switchToNewTab() {
        log.info("");

        String originalWindow = BrowserFactory.getDriver().getWindowHandle();

        for (String windowHandle : BrowserFactory.getDriver().getWindowHandles()) {

            if(!originalWindow.contentEquals(windowHandle)) {
                BrowserFactory.getDriver().switchTo().window(windowHandle);

                break;
            }
        }
    }

    public static void closeTab(String originalWindow) {
        log.info("");

        BrowserFactory.getDriver().close();

        BrowserFactory.getDriver().switchTo().window(originalWindow);
    }

    public static void uploadFile(BaseElement element, String filePath) {
        log.info("");

        element.findElement().sendKeys(filePath);
    }
}