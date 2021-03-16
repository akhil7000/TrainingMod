package com.training.web.tests.flipkart;

import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.FlipkartHomePage;
import com.training.web.pages.flipkart.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

public class PaymentPageTests extends WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    PaymentPage paymentPage;

    @BeforeEach
    public void startup() {
        open("https://www.flipkart.com/");
        paymentPage = new FlipkartHomePage().closePopup().clickPayments();
    }

    @Test
    public void testPaymentPageNavigation() {

        String url = paymentPage.getUrl();
        /**
         * Assertiong the test has navigated to payments page
         */
        softAssertions.assertThat(url).as("Test didn't navigate to payment page")
                .isEqualTo("https://www.flipkart.com/pages/payments");

        /**
         * Assertion for number of questions
         */
        int numberOfQuestion = paymentPage.getNumberOfQuestions();
        softAssertions.assertThat(14).as("Number of question are not accurate")
                .isEqualTo(numberOfQuestion);
    }
}