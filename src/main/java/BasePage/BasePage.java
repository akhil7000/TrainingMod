package BasePage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public Boolean isDisplayedWait(SelenideElement element) {
        try {
            element.shouldBe(Condition.visible);
            logger.info("Elmenent found");
            return true;
        }catch (Exception e){
            logger.info("Elmenent not found");
            return false;
        }
    }
}
