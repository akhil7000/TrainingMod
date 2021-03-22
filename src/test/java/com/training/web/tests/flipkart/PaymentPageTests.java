package com.training.web.tests.flipkart;

import com.codeborne.selenide.WebDriverRunner;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.FlipkartHomePage;
import com.training.web.pages.flipkart.PaymentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

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

        Assertions.assertEquals(paymentPage.getUrl(), "https://www.flipkart.com/pages/payments",
                "Test didn't navigate to payment page");

        Assertions.assertEquals(paymentPage.getTitle(),map.get("paymentPageTitle"),"Title of Payment Page not correct");

        softAssertions.assertThat(Integer.parseInt(map.get("numberOfQuestions"))).as("Number of question are not accurate")
                                   .isEqualTo(paymentPage.getNumberOfQuestions());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testEmiOptions.csv")
    public void testEmiOptions(String bankName) {

        softAssertions.assertThat(paymentPage.checkEmiSupport(bankName)).as("Bank details inaccurate")
                .isEqualTo("No");
    }
}