package web.tests;

import assertpage.PaymentPage;
import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

public class FlipkartTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp() {
        Selenide.open(map.get("url"));
    }

    /**
     * testQuestionsOnPaymentPage:selecting payment page and counting number of questions available on page.
     */
    @Test
    public void testQuestionsOnPaymentPage(){
        PaymentPage paymentPage=new HomePage().popUpCancel().goToPaymentPage();
        softAssert.assertThat(paymentPage.currentPageHeader().equalsIgnoreCase(map.get("paymentPageHeader")));
        Assertions.assertEquals(Integer.parseInt(map.get("expectedQuestionsOnPaymentPage")),paymentPage.getQuestionsCount());
    }

    /**
     * testSortFilter :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testSortFilter.csv")
    public void testSortFilter(String product, String pagelimit) {
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");
        for (int page = 1; page <=Integer.parseInt(pagelimit); page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
           softAssert.assertThat(searchPage.countingPagePrices()).as("prices list not matching").isTrue();
        }
      logger.info("Assertion working");
    }
}