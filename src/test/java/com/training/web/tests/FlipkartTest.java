package com.training.web.tests;

import com.codeborne.selenide.Selenide;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.web.pages.flipkart.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.closeWindow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

        IntStream.range(0, Integer.parseInt(pagelimit)).forEach(page -> {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
            softAssert.assertThat(searchPage.countingPagePrices())
                    .as("prices list not matching").isTrue();
        });
    }

    /**
     * @param bankName:inserting bank name from json to check tenure facility available or not
     * @param tenure:inserting   tenure facility available ie YES or No
     * @throws Exception :Base exception to hanle exception at runtime
     * @testEmiOptions:Method to check banks tenure facilities
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testEmiOptions.csv")
    public void testEmiOptions(String bankName, String tenure) {
        PaymentPage paymentPage = new HomePage().popUpCancel().goToPaymentPage();
        logger.info("testemi**********");
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
        IntStream.range(0, shoeno.length).forEach(row -> {
            IntStream.range(0, 2).forEach(col -> {
                if (col == 0) {
                    productNameAndPrice[row][col] = searchPage.getProductName(shoeno[row]);
                }
                if (col == 1) {
                    productNameAndPrice[row][col] = searchPage.getProductPrice(shoeno[row]);
                }
            });
        });

        /**
         * Selecting shoe 1 and adding in cart , same procedure for other shoes
         */
        IntStream.range(0, shoeno.length).forEach(index -> {
            searchPage.OpenProductPage(shoeno[index]).clickShoeSize().addToCartShoe();
            /**
             * If you are selecting last shoe than below if statement will not run, it will not switch to parent window
             */
            if (!((shoeno.length - 1) == index)) {
                switchParentWindow();
            }
        });

        /**
         * getting ProductName And Price From AddtoCart
         */
        CartPage cartPage = new CartPage();
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
        AtomicInteger totalPriceOfShoeSelectedFromList = new AtomicInteger();
        IntStream.range(0, productNameAndPrice.length).forEach(row -> {
            totalPriceOfShoeSelectedFromList.set(totalPriceOfShoeSelectedFromList.get() + Integer.parseInt(productNameAndPrice[row][1]));
        });

        softAssert.assertThat(Integer.parseInt(cartPage.getShoePriceTotalInCart()) == totalPriceOfShoeSelectedFromList.get()).isTrue();
    }

    /**
     * @param :accepting shoes from json
     *                   Below testcase is clicking policies and checking the header and back to top button
     */
    @Test
    public void testPolicyBackToTop() {
        ArrayList<String> policyElementsWhichNeedToClick =
                new ArrayList<>(Arrays.asList(map.get("policyElementsWhichNeedToClick").split(",")));
        ArrayList<String> policyHeaders =
                new ArrayList<>(Arrays.asList(map.get("policyHeaders").split(",")));

        HomePage homePage = new HomePage().popUpCancel();

        IntStream.range(0, policyHeaders.size()).forEach(count -> {
            PolicySubPage policySubPage = homePage.clickPolicySingleElement(policyElementsWhichNeedToClick.get(count));

            softAssert.assertThat(policySubPage.isHeaderDisplayed(policyHeaders.get(count)))
                    .as("Header Not Displayed in = " + policyElementsWhichNeedToClick.get(count))
                    .isTrue();

            softAssert.assertThat(policySubPage.scrollPageToFooter())
                    .as("Footer is not displayed = " + policyElementsWhichNeedToClick.get(count))
                    .isTrue();

            softAssert.assertThat(policySubPage.clickBackToTopButton(policyElementsWhichNeedToClick.get(count)))
                    .as("Back to top button is not displayed = "
                            + policyElementsWhichNeedToClick.get(count)).isTrue();

            softAssert.assertThat(policySubPage.checkIfBackToTopButtonIsDisapperAndverifyPageGoesUp
                    (policyElementsWhichNeedToClick.get(count)))
                    .as("Page = " + policyElementsWhichNeedToClick.get(count)
                            + " doesnt scrolled up or back to top button is disappear")
                    .isTrue();

            softAssert.assertThat(policySubPage.isHeaderDisplayed(policyHeaders.get(count)))
                    .as("After clicking back to top button, Header Not Displayed in = "
                            + policyElementsWhichNeedToClick.get(count))
                    .isTrue();

            closeWindow();

            switchParentWindow();
        });
    }

    /*
     * @param item :accepting shoes from json
     * @param position :accepting position i.e to select 2nd position shoes
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testProductPageDesign.csv")
    public void testProductPageDesign(String item, int position) {
        ProductPage productPage = new HomePage().popUpCancel().setShoes(item).searchShoes().OpenProductPage(position);
        productPage.scrollToBottom();

        ArrayList<String> headers = new ArrayList<>(Arrays.asList(map.get("headers").split(",")));

        headers.forEach(header ->
                softAssert.assertThat(productPage.isSelectionDisplayed(header)).
                        as("Json selected Headers is Not matching with selection page Headers").isTrue());
    }

    /**
     * flipkartSocialMedia(): Clicking the social media links and checking the new tab url and comparing it with links present in json
     */
    @Test
    public void flipkartSocialMedia() {
        HomePage homePage = new HomePage().popUpCancel();

        ArrayList<String> socialMediaLinksArrayList = new ArrayList<>(Arrays.asList(map.get("links")
                .split(",")));
        ArrayList<String> placeholdersOfSocialSites = new ArrayList<>(Arrays.asList(map.get("placeholders")
                .split(",")));

        IntStream.range(0, socialMediaLinksArrayList.size()).forEach(count -> {
            SocialMediaPage socialMediaPage = homePage.clickLink(socialMediaLinksArrayList.get(count));

            softAssert.assertThat(socialMediaPage.getSocialMediaUrl(placeholdersOfSocialSites.get(count)))
                    .contains(socialMediaLinksArrayList.get(count).toLowerCase()).
                    as("links of social media are not matching with the contents in url");

            Selenide.back();
        });
    }

    /**
     * Checking the main page mail us, register office address, Corporate Address, Postal Address match the given regex.
     */
    @Test
    public void testContactUsPostalAddress() {
        HomePage homePage = new HomePage().popUpCancel();
        ContactPage cotactPage = homePage.clickContactUS().clickPostalAddress();

        softAssert.assertThat(homePage.getMailUsAddress())
                .as("Mail Us Address doesnt match given regex")
                .matches("^[a-zA-Z0-9 &:,]*$");

        softAssert.assertThat(homePage.getRegisteredOfficeAddress())
                .as("Registered Office Address doesnt match given regex")
                .matches("^[a-zA-Z0-9 &:,]*$");

        softAssert.assertThat(cotactPage.getCorporateAddress())
                .as("Corporate Address doesnt match given regex")
                .matches("^[a-zA-Z0-9 &:,]*$");

        softAssert.assertThat(cotactPage.getPostalAddress())
                .as("Registered Office Address doesnt match given regex")
                .matches("^[a-zA-Z0-9 &:,]*$");
    }
}