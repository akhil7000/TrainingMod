package com.training.web.tests.flipkart;

import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.FlipkartHomePage;
import com.training.web.pages.flipkart.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        softAssertions.assertThat(paymentPage.getUrl()).as("Test didn't navigate to payment page")
                .isEqualTo("https://www.flipkart.com/pages/payments");

        /**
         * Assertion for number of questions
         */
        softAssertions.assertThat(14).as("Number of question are not accurate")
                .isEqualTo(paymentPage.getNumberOfQuestions());
    }

    @Test
    public void testEmiOptions2() {
       int[] ind={6,8};
       ArrayList<Integer> index = paymentPage.checkEmiSupport();
       softAssertions.assertThat(ind).as("Index does not match").isEqualTo(index.toArray());
    }
}