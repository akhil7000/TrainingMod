package assertpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AssertPage extends HomePage {
   public SelenideElement payment_page = $x("//a[contains(text(),'Payments')]");
    public SelenideElement current_page_check = $x("//h2[@id='payments']");
    ElementsCollection questions = $$x("//h2");
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public HomePage popUpCancel() {
        return super.popUpCancel();
    }
    public AssertPage paymentPage(){
    payment_page.shouldBe(Condition.visible).click();
        return this;
    }
    public String currentPageCheck(){
        return current_page_check.shouldBe(Condition.visible).getText();
    }
    public int countingQuestions() {
        return  questions.size();
    }
}
