package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

public class FlipkartTest extends BaseTest {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp() {
        Selenide.open(map.get("url"));
    }

    /**
     * testGetDetails :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/Flipkart.csv")
    public void testGetDetails(String product, String pagelimit) {
        int pagelimit2 = Integer.parseInt(pagelimit);
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");
        for (int page = 1; page <= pagelimit2; page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
            Assertions.assertTrue(searchPage.countingPagePrices(), "prices not matching");
        }
    }
}
