import framework.elements.Text;
import framework.baseForm.BaseForm;
import framework.frame.Frame;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import framework.utils.BrowserManagerUtil;

public class FramesPage extends BaseForm {
    private Frame topFrame = new Frame("topFrame", By.xpath("//iframe[@id='frame1']"));
    private Text topFrameText = new Text("topFrameText", By.xpath("//h1[@id='sampleHeading']"));
    private Frame bottomFrame = new Frame("bottomFrame", By.xpath("//iframe[@id='frame2']"));
    private Text bottomFrameText = new Text("bottomFrameText", By.xpath("//h1[@id='sampleHeading']"));
    public LeftForm leftForm = new LeftForm();

    private static final Logger log = LoggerFactory.getLogger(FramesPage.class);

    public FramesPage() {
        super("FramesPage", new Text("framesPageMainHeader", By.xpath("//div[@class='main-header' and text()='Frames']")));
    }

    public String getTopFrameText() {
        log.info("");

        BrowserManagerUtil.switchToFrame(topFrame);

        String result = topFrameText.getText();

        BrowserManagerUtil.quitFrames();

        return result;
    }

    public String getBottomFrameText() {
        log.info("");

        BrowserManagerUtil.switchToFrame(bottomFrame);

        String result = bottomFrameText.getText();

        BrowserManagerUtil.quitFrames();

        return result;
    }
}