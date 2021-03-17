package com.training.web.tests.flipkart;

import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.FlipkartHomePage;
import com.training.web.pages.flipkart.PaymentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.open;

public class PaymentPageTests extends WebBaseTest {
    PaymentPage paymentPage;

    @BeforeEach
    public void startup() {
        open("https://www.flipkart.com/");
        paymentPage = new FlipkartHomePage().closePopup().clickPayments();
    }

    @Test
    public void testPaymentPageNavigation() {

        /**
         * Assertiong the test has navigated to payments page
         */

        Assertions.assertEquals(paymentPage.getUrl(), "https://www.flipkart.com/pages/payments",
                "Test didn't navigate to payment page");
        /**
         * Assertion for number of questions
         */
        softAssertions.assertThat(14).as("Number of question are not accurate")
                .isEqualTo(paymentPage.getNumberOfQuestions());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testEmiOptions.csv")
    public void testEmiOptions(String bankName) {

        softAssertions.assertThat(paymentPage.checkEmiSupport(bankName)).as("Bank details inaccurate")
                .isEqualTo("No");
    }
}