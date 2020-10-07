package assertpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    public SelenideElement current_page_check = $x("//h2[@id='payments']");
    ElementsCollection questions = $$x("//h2[contains(text(),'?')]");
    public String currentPageCheck(){
        return current_page_check.shouldBe(Condition.visible).getText();
    }
    public int countingQuestions() {
        return  questions.size();
    }
}
