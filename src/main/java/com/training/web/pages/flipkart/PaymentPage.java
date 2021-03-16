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
    private String tableHeader= "//strong[text()='Banks']";
    //private String tableColumn1 = "//table[contains(.,'Banks')]/tbody/tr/td[1]";
    //private String tableColumn2 = "//table[contains(.,'Banks')]/tbody/tr/td[2]";

    public String getUrl() {
        $x(paymentHeading).shouldBe(Condition.visible);
        String url = driver.getCurrentUrl();
        logger.info(url);
        return url;
    }

    public int getNumberOfQuestions() {
        $x(paymentHeading).shouldBe(Condition.visible);
        List<SelenideElement> questionList = $$x(questions);
        return questionList.size();
    }

    public ArrayList<Integer> checkEmiSupport() {
        $x(tableHeader).shouldBe(Condition.visible);
        ArrayList<Integer> supportIndex = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        List<SelenideElement> tablecolumn = $$x("//table[contains(.,'Banks')]/tbody/tr/td[1]");
        List<SelenideElement> tablecolumn2 = $$x("//table[contains(.,'Banks')]/tbody/tr/td[2]");

        ArrayList<String> support = new ArrayList<>();
        for(int i=0;i<9;i++) {
            names.add(tablecolumn.get(i).getText());
            support.add(tablecolumn2.get(i).getText());
        }
        for (int i = 0; i < support.size(); i++) {
            if (support.get(i).equalsIgnoreCase("No")) {
                supportIndex.add(i);
            }
        }
        return supportIndex;
    }
}
