package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

public class FlipkartTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        Selenide.open(map.get("url"));
    }

    /**
     * testGetDetails :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/Flipkart.csv")
    public void testGetDetails(String product, String pagelimit) {
        int max_page_limit= Integer.parseInt(pagelimit);
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");
        for (int page = 1; page <= max_page_limit; page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
            Assertions.assertTrue(searchPage.countingPagePrices(), "prices not matching");
        }
    }
}
