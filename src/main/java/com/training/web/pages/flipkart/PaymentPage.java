package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage extends FlipkartBasePage {

    private String questions = "//h2[contains(text(),'?')]";
    private String paymentHeading = "//h2[@id='payments']";
    private String tableHeader = "//strong[text()='Banks']";
    private String tableColumn1 = "//table[contains(.,'Banks')]/tbody/tr/td[1]";
    private String column1Element = "//table[contains(.,'Banks')]/tbody/tr[%s]/td[1]";
    private String column2Element = "//table[contains(.,'Banks')]/tbody/tr[%s]/td[2]";

    SelenideElement btp = $x("//span[text()='Back to top']");
    SelenideElement end = $x("//p[contains(text(),'Please note')]");


    public String getUrl() {
        $x(paymentHeading).shouldBe(Condition.visible);
        return driver.getCurrentUrl();
    }

    public int getNumberOfQuestions() {
        $x(paymentHeading).shouldBe(Condition.visible);
        return $$x(questions).size();
    }

    public String getEmiSupport(String bankName) {
        String tenure = null;
        $x(tableHeader).shouldBe(Condition.visible);
        List<SelenideElement> bankColumn = $$x(tableColumn1);

        for (int index = 1; index <= bankColumn.size(); index++) {
            String bank = $x(String.format(column1Element, index)).getText();
            if (bank.equalsIgnoreCase(bankName)) {
                tenure = $x(String.format(column2Element, index)).getText();
            }
        }
        return tenure;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}