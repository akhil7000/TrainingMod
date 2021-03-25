package com.training.web.tests.flipkart;

import com.codeborne.selenide.Condition;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.ContactUsPage;
import com.training.web.pages.flipkart.FlipkartHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class ContactUsTest extends WebBaseTest {
    FlipkartHomePage flipkartHomePage;
    ContactUsPage contactUsPage;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void startup() {
        open("https://www.flipkart.com/");
        flipkartHomePage = new FlipkartHomePage().closePopup();
    }

    @Test
    public void testAddressValidation(){
        String mailAddress = flipkartHomePage.getMailAddress();
        String officeAddress = flipkartHomePage.getOfficeAddress();
        contactUsPage = flipkartHomePage.clickContactUs().clickPostalAddress();
        String postalAddress = contactUsPage.getPostalAddress();
        String corporateAddress = contactUsPage.getCorporateAddress();
        Assertions.assertEquals(postalAddress,mailAddress,"Postal Addresses don't match");
        Assertions.assertTrue(officeAddress.contains(corporateAddress),"Office Addresses don't match");

    }
}
