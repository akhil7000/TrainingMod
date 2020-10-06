package com.training.assertpage.tests;

import assertpage.AssertPage;
import com.codeborne.selenide.Selenide;
import com.training.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;

public class AssertTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void test1SetUp() {
        Selenide.open(map.get("url"));
    }
     @Test
    public void testCurrentPage(){
        HomePage homePage=new HomePage();
        AssertPage assertPage=new AssertPage();
        homePage.popUpCancel();
        assertPage.paymentPage();
        String current_page_text=assertPage.currentPageCheck();
        logger.info(current_page_text);
        softAssert.assertThat(current_page_text.equalsIgnoreCase("Payments"));
        int counting= assertPage.countingQuestions();
        logger.info(String.valueOf(counting));
     }
}
