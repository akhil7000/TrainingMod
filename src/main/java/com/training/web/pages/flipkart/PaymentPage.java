package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SelenideElement paymentHeader = $x("//h2[@id='payments']");
    private ElementsCollection questions = $$x("//h2[contains(text(),'?')]");
    private String bank_xpath = "//table[3]/tbody/tr[%s]/td[1]";
    private String tenure_xpath = "//table[3]/tbody/tr[%s]/td[2]";
    private SelenideElement  columnNameBanksForAddingDelay=$x("//th/child::strong[text()='Banks']");
    private ElementsCollection Rows=$$x("//table[3]/tbody/tr");

    public String getCurrentPageHeader(){
        return paymentHeader.shouldBe(Condition.visible).getText();
    }

    public int getQuestionsCount() {
        return  questions.size();
    }

    public String getEmiRow(String bankName){
        logger.info(bankName);
        columnNameBanksForAddingDelay.shouldHave(Condition.visible);
        for (int countRow = 1; countRow <= Rows.size(); countRow++) {
            SelenideElement row_bank_element = $x(String.format(bank_xpath,countRow));
            logger.info("banks=" + row_bank_element.getText());
            if (row_bank_element.getText().equals(bankName)) {
                logger.info("Bank name:" + row_bank_element.getText() + "is found");
                logger.info("position of bank is " + countRow);
                return String.valueOf(countRow);
            }
        }
        return null;
    }

    public String getEmiTenure(int emiRow) {
        return $x(String.format(tenure_xpath, emiRow)).getText();
    }
}