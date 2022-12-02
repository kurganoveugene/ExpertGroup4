import framework.baseElement.BaseElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseForm {
    private String name;
    private BaseElement uniqueElement;

    private static final Logger log = LoggerFactory.getLogger(BaseForm.class);

    public BaseForm(String name, BaseElement uniqueElement) {
        log.info("Page: {}, unique element: {}", name, uniqueElement.getName());

        this.name = name;
        this.uniqueElement = uniqueElement;
    }

    public BaseForm() {
    }

    public boolean isPageOpen() {
        log.info("Page: {}", name);

        uniqueElement.visibilityOfElement();

        uniqueElement.scrollToElement();

        return uniqueElement.findElements().size() > 0;
    }
}