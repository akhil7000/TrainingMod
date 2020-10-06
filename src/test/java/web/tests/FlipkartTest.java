package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.CartPage;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

import java.util.function.BooleanSupplier;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/Flipkart2.csv")
    public void test2(String product) {

        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High").doAllOpearation1();

        Assertions.assertTrue(searchPage.shoeOnePresentInCart());
        Assertions.assertTrue(searchPage.shoeSecondPresentInCart());
        Assertions.assertTrue(searchPage.checkPriceTotal());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Flipkart2.csv")
    public void test3(String product) {


        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");

//                .doAllOpearation1();
        String productName1 = searchPage.getProductName(2);
        System.out.println("productName1 = = "+productName1);
        String productName2 = searchPage.getProductName(3);
        System.out.println("productName2 = = "+productName2);

        String productPrice1 =  searchPage.getProductPrice(2);
        System.out.println("productPrice1 = = "+productPrice1);
        String productPrice2 =  searchPage.getProductPrice(3);
        System.out.println("productPrice2 = = "+productPrice2);




        searchPage.OpenProductPage(2).windowHandel().addToCart();
//                .switchParentWindow()




        CartPage cartPage=  searchPage.OpenProductPage(3).windowHandel().addToCart();


        SoftAssertions softly = new SoftAssertions();
        System.out.println("cartPage.getProductName(1) = "+cartPage.getProductName(1));
        System.out.println("cartPage.getProductName(2) = "+cartPage.getProductName(2));
        softly.assertThat(cartPage.getProductName(1).contains(productName1)).isTrue();
        softly.assertThat(cartPage.getProductName(2).contains(productName2)).isTrue();

        softly.assertThat(cartPage.getProductPrice(2).contains(productPrice1)).isTrue();
        softly.assertThat(cartPage.getProductPrice(3).contains(productPrice2)).isTrue();

        softly.assertThat(Integer.parseInt(cartPage.checkShoePriceTotalInCart())==(Integer.parseInt(productPrice1)+Integer.parseInt(productPrice2)));


        softly.assertAll();
//        Assertions.assertTrue(cartPage.getProductName(1).contains(productName1));
//        Assertions.assertTrue(cartPage.getProductName(2).contains(productName2));
//        Assertions.assertTrue(cartPage.getProductPrice(2).contains(productPrice1));
//        Assertions.assertTrue(cartPage.getProductPrice(3).contains(productPrice2));

//        Assertions.assertEquals(productName1, cartPage.getProductName(1));
//        Assertions.assertEquals(productName2, cartPage.getProductName(2));
//        Assertions.assertEquals(productPrice1, cartPage.getProductPrice(2));
//        Assertions.assertEquals(productPrice2, cartPage.getProductPrice(3));



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
