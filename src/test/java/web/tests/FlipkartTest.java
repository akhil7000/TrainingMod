package web.tests;

import web.pages.flipkart.*;
import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
        for (int page = 1; page <= Integer.parseInt(pagelimit); page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
            softAssert.assertThat(searchPage.countingPagePrices()).as("prices list not matching").isTrue();
        }
        logger.info("Assertion working");
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
    public void testQuestionsOnPaymentPage() {
        PaymentPage paymentPage = new HomePage().popUpCancel().goToPaymentPage();
        Assertions.assertEquals(paymentPage.getCurrentPageHeader(), map.get("paymentPageHeader"),
                "Payment header not matching");
        Assertions.assertEquals(Integer.parseInt(map.get("expectedQuestionsOnPaymentPage")),
                paymentPage.getQuestionsCount(), "questions count mismatch");
    }

    /**
     * testAddToCartFunctionality() : In this we are checking add to cart functionality, checking the shoe selected from list is present in cart, also checking price
     *
     * @param product
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testAddToCartFunctionality.csv")
    public void testAddToCartFunctionality(String product) {
        String shoenoInString[] = map.get("select_shoe").split(",");
        int[] shoeno = Arrays.asList(shoenoInString).stream().mapToInt(Integer::parseInt).toArray();
        String[][] productNameAndPrice = new String[shoeno.length][2];
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().sortShoes("Price -- Low to High");

        /**
         * Getting the product name and price of shoe and storing in array
         */
        for (int row = 0; row < shoeno.length; row++) {
            for (int col = 0; col < 2; col++) {
                productNameAndPrice[row][col] = searchPage.getProductName(shoeno[row]);
                col = col + 1;
                productNameAndPrice[row][col] = searchPage.getProductPrice(shoeno[row]);
            }
        }

        /**
         * Just printing product Name And Price array
         */
        for (int row = 0; row < shoeno.length; row++) {
            for (int col = 0; col < 2; col++) {
                logger.info("****productNameAndPrice = *** = " + productNameAndPrice[row][col]);
            }
        }

        /**
         * Selecting shoe 1 and adding in cart , same procedure for other shoes
         */
        CartPage cartPage = null;
        for (int index = 0; index < shoeno.length; index++) {
            cartPage = searchPage.OpenProductPage(shoeno[index]).clickShoeSize().addToCartShoe();
            /**
             * If you are selecting last shoe than below if statement will not run, it will not switch to parent window
             */
            if (!((shoeno.length - 1) == index)) {
                switchParentWindow();
            }
        }

        /**
         * getting ProductName And Price From AddtoCart
         */
        String[][] getProductNameAndPriceFromAddtoCart = new String[shoeno.length][2];
        for (int row = 0; row < shoeno.length; row++) {
            for (int col = 0; col < 2; col++) {
                int positionOfProductName = row + 1;
                int positionOfPrice = positionOfProductName + 1;
                getProductNameAndPriceFromAddtoCart[row][col] = cartPage.getProductName(positionOfProductName);
                col = col + 1;
                getProductNameAndPriceFromAddtoCart[row][col] = cartPage.getProductPrice(positionOfPrice);
            }
        }

        /**
         * Just printing the array and seeing the value
         */
        for (int row = 0; row < getProductNameAndPriceFromAddtoCart.length; row++) {
            for (int col = 0; col < 2; col++) {
                logger.info("****getProductNameAndPriceFromAddtoCart = *** = " + getProductNameAndPriceFromAddtoCart[row][col]);
            }
        }

        /**
         * Now comparing 2 array product shoes, not price
         */
        for (int row = 0; row < productNameAndPrice.length; row++) {

            String singelProductNameAndPriceFromList = productNameAndPrice[row][0];
            int rowToCheckProduct;
            logger.info("singelProductNameAndPriceFromListtttt = " + singelProductNameAndPriceFromList);
            for (rowToCheckProduct = 0; rowToCheckProduct < getProductNameAndPriceFromAddtoCart.length; rowToCheckProduct++) {
                logger.info("getProductNameAndPriceFromAddtoCarttttt[rowToCheckProduct][0] = " + getProductNameAndPriceFromAddtoCart[rowToCheckProduct][0]);
                if (getProductNameAndPriceFromAddtoCart[rowToCheckProduct][0].contains(singelProductNameAndPriceFromList)) {
                    break;
                }
            }

            /**
             * If we dont find the product in getProductNameAndPriceFromAddtoCart[][] array, then the softAssert will fail
             */
            logger.info("counterrr = " + rowToCheckProduct);
            softAssert.assertThat(rowToCheckProduct != getProductNameAndPriceFromAddtoCart.length).isTrue();
        }

        /**
         * Now checking the total price of selected shoe from list
         */
        int totalPriceOfShoeSelectedFromList = 0;
        for (int row = 0; row < productNameAndPrice.length; row++) {
            totalPriceOfShoeSelectedFromList = totalPriceOfShoeSelectedFromList + Integer.parseInt(productNameAndPrice[row][1]);
        }
        softAssert.assertThat(Integer.parseInt(cartPage.getShoePriceTotalInCart()) == totalPriceOfShoeSelectedFromList).isTrue();
    }

    /**
     *
     * @param item :accepting shoes from json
     * @param position :accepting position i.e to select 2nd position shoes
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/validatePageHeaders.csv")
    public void testPageHeaders(String item,int position) throws InterruptedException {
        ProductPage productPage = new HomePage().popUpCancel().setShoes(item).searchShoes().OpenProductPage(position);
        String[] headersText = map.get("headers").split(",");

        for (int row = 0; row < headersText.length; row++) {
            System.out.println("uuuuuuuuuuuuuuuuuu= "+headersText[row]);
            Assertions.assertTrue(productPage.isSelectionDisplayed(headersText[row]));
        }
    }
}