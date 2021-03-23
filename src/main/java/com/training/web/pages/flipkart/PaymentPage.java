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
    private String bankNameColumn = "//table[contains(.,'Banks')]/tbody/tr/td[1]";
    private String banksElement = "//table[contains(.,'Banks')]/tbody/tr[%s]/td[1]";
    private String tenureElement = "//table[contains(.,'Banks')]/tbody/tr[%s]/td[2]";

    public String getUrl() {
        $x(paymentHeading).shouldBe(Condition.visible);
        return driver.getCurrentUrl();
    }

    public int getNumberOfQuestions() {
        $x(paymentHeading).shouldBe(Condition.visible);
        return $$x(questions).size();
    }

    public String getEmiSupport(String bankName) {
        $x(tableHeader).shouldBe(Condition.visible);
        List<SelenideElement> bankColumn = $$x(bankNameColumn);

        for (int index = 1; index <= bankColumn.size(); index++) {
            String bank = $x(String.format(banksElement, index)).getText();
            if (bank.equalsIgnoreCase(bankName)) {
                return  $x(String.format(tenureElement, index)).getText();
            }
        }
        return "";
    }

    public String getTitle() {
        return driver.getTitle();
    }
}