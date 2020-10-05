package BasePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public Boolean isDisplayedWait(SelenideElement element) {
        try {
            element.shouldBe(Condition.enabled);
            logger.info("Element found");
            return true;
        }catch (ElementNotFound e){
            logger.info("Element not found");
            return false;
        }
    }
}
