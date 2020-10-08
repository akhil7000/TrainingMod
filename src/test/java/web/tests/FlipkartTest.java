package web.tests;

import web.pages.flipkart.PaymentPage;
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
     * @param bankName:inserting bank name from json to check tenure facility available or not
     * @param tenure:inserting   tenure facility available ie YES or No
     * @throws Exception :Base exception to hanle exception at runtime
     * @testEmiOptions:Method to check banks tenure facilities
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testEmiOptions.csv")
    public void testEmiOptions(String bankName, String tenure) throws Exception {
        PaymentPage paymentPage = new HomePage().popUpCancel().goToPaymentPage();
        String emiRow = paymentPage.getEmiRow(bankName);
        logger.info(emiRow);
        Assertions.assertTrue(paymentPage.getEmiTenure(Integer.parseInt(emiRow)).equals(tenure));
    }

    /**
     * testQuestionsOnPaymentPage:count number of questions available on payment page
     */
    @Test
    public void testQuestionsOnPaymentPage () {
        PaymentPage paymentPage = new HomePage().popUpCancel().goToPaymentPage();
        Assertions.assertEquals(paymentPage.getCurrentPageHeader(),map.get("paymentPageHeader"),"Payment header not matching");
        Assertions.assertEquals(Integer.parseInt(map.get("expectedQuestionsOnPaymentPage")), paymentPage.getQuestionsCount(),"questions count mismatch");
        }

        /**
         * testSortFilter :In this method shoes selection operation performed by using low to high filter
         */
        @ParameterizedTest
        @CsvFileSource(resources = "/testSortFilter.csv")
        public void testSortFilter(String product,String pagelimit){
            SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                    sortShoes("Price -- Low to High");
            for (int page = 1; page <= Integer.parseInt(pagelimit); page++) {
                if (page != 1) {
                    searchPage.selectPageNumber(page);
                }
                softAssert.assertThat(searchPage.countingPagePrices()).as("prices list not matching").isTrue();
            }
            logger.info("Assertion working");
        }
    }