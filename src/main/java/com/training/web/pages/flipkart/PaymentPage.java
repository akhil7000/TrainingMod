package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String questions = "//h2[contains(text(),'?')]";
    private String paymentHeading = "//h2[@id='payments']";
    private String tableHeader = "//strong[text()='Banks']";
    private String tableColumn1 = "//table[contains(.,'Banks')]/tbody/tr/td[1]";
    private String tableColumn2 = "//table[contains(.,'Banks')]/tbody/tr/td[2]";
    private String lastTableElement = "//table[contains(.,'Banks')]/tbody/tr[9]/td[3]";

    public String getUrl() {
        $x(paymentHeading).shouldBe(Condition.visible);
        return driver.getCurrentUrl();

    }

    public int getNumberOfQuestions() {
        $x(paymentHeading).shouldBe(Condition.visible);
        List<SelenideElement> questionList = $$x(questions);
        return questionList.size();
    }

    public String checkEmiSupport(String bankName) {
        $x(tableHeader).shouldBe(Condition.visible);
        actions.moveToElement($x(lastTableElement));
        ArrayList<String> names = new ArrayList<>();
        List<SelenideElement> bankColumn = $$x(tableColumn1);
        List<SelenideElement> supportColumn = $$x(tableColumn2);
        ArrayList<String> support = new ArrayList<>();

        for (int j = 0; j < bankColumn.size(); j++) {
            names.add(bankColumn.get(j).getText());
            support.add(supportColumn.get(j).getText());
        }
        return support.get(names.indexOf(bankName));
    }
}
