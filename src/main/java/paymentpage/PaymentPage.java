package paymentpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement paymentHeader = $x("//h2[@id='payments']");
    ElementsCollection questions = $$x("//h2[contains(text(),'?')]");
    String bank_xpath = "//table[3]/tbody/tr[%s]/td[1]";
    String tenure_xpath = "//table[3]/tbody/tr[%s]/td[2]";

    public String getCurrentPageHeader(){
        return paymentHeader.shouldBe(Condition.visible).getText();
    }

    public int getQuestionsCount() {
        return  questions.size();
    }

    public int getEmiRow(String bankName) throws Exception {
        int i;
        for (i = 1; i <= 9; i++) {
            SelenideElement row_bank_element = $x(String.format(bank_xpath, i));
            logger.info("banks=" + row_bank_element.getText());
            if (row_bank_element.getText().equals(bankName)) {
                logger.info("Bank name:" + row_bank_element.getText() + "is found");
                logger.info("position of bank is " + i);
                break;
            }
        }
        return i;
    }

    public String getEmiTenure(int emiRow) {
        String tenure_element = $x(String.format(tenure_xpath, emiRow)).getText();
        logger.info("tenure=="+tenure_element);
        return tenure_element;
    }
}