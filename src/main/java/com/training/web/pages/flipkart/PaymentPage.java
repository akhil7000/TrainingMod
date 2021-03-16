package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String questions = "//h2[contains(text(),'?')]";
    private String paymentHeading="//h2[@id='payments']";

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
}
