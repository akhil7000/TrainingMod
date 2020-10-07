package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.CartPage;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

public class FlipkartTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp() {
        Selenide.open(map.get("url"));
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

    @ParameterizedTest
    @CsvFileSource(resources = "/addToCartFunctionality.csv")
    public void addToCartFunctionality(String product) {

        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");

        String productName1 = searchPage.getProductName(2);
        System.out.println("productName1 = = "+productName1);
        String productName2 = searchPage.getProductName(3);
        System.out.println("productName2 = = "+productName2);

        String productPrice1 =  searchPage.getProductPrice(2);
        System.out.println("productPrice1 = = "+productPrice1);
        String productPrice2 =  searchPage.getProductPrice(3);
        System.out.println("productPrice2 = = "+productPrice2);

        searchPage.OpenProductPage(2).addToCart();

        switchParentWindow();

        CartPage cartPage=  searchPage.OpenProductPage(3).addToCart();

        System.out.println("cartPage.getProductName(1) = "+cartPage.getProductName(1));
        System.out.println("cartPage.getProductName(2) = "+cartPage.getProductName(2));
        softAssert.assertThat(cartPage.getProductName(1).contains(productName1)).isTrue();
        softAssert.assertThat(cartPage.getProductName(2).contains(productName2)).isTrue();

        softAssert.assertThat(cartPage.getProductPrice(2).contains(productPrice1)).isTrue();
        softAssert.assertThat(cartPage.getProductPrice(3).contains(productPrice2)).isTrue();

        softAssert.assertThat(Integer.parseInt(cartPage.checkShoePriceTotalInCart())==(Integer.parseInt(productPrice1)+Integer.parseInt(productPrice2)));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}