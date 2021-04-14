package com.training.web.tests.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FlipkartTest extends WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    ResultPage resultPage;
    FlipkartHomePage flipkartHomePage;

    @BeforeEach
    public void startup() {
        open(map.get("flipkartUrl"));
        flipkartHomePage = new FlipkartHomePage().closePopup();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testPriceSort.csv")
    public void testPriceSort(String searchItem, String pages) throws WebDriverException, ParseException {

        resultPage = flipkartHomePage.sendKeysToSearchBox(searchItem).clickSearch()
                .sortLowToHigh();

        int numberOfPages = Integer.parseInt(pages);

        /**
         * extracting price and going to next pages for 'n' pages
         */

        for (int page = 1; page <= numberOfPages; page++) {
            ArrayList<Integer> priceList = resultPage.getPrice();

            logger.info("Assert for price");
            softAssertions.assertThat(priceList).as("Price not in order")
                    .isEqualTo(resultPage.sortPriceList(priceList));

            if (page != numberOfPages) {
                logger.info("Navigating to page " + (page + 1));
                resultPage.clickNextPage();
            }
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testCartAddition.csv")
    public void testCartAddition(String search, String productsList) throws ParseException {
        resultPage = flipkartHomePage.sendKeysToSearchBox(search).clickSearch()
                .sortLowToHigh();
        String[] strProductArray = productsList.split(",");
        int[] productArray = Arrays.stream(strProductArray).mapToInt(Integer::parseInt).toArray();


        String parentWindow = getWebDriver().getWindowHandle();

        /**
         * Select and add to cart item 2 and 3
         */
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> priceList = new ArrayList<>();
        List<SelenideElement> productResults = resultPage.getProductsList();

        for (int index : productArray) {
            ProductPage productPage = resultPage.clickProduct(productResults, index).clickFirstAvailableSize();
            productNames.add(productPage.getProductName());
            priceList.add(productPage.getProductPrice());
            productPage.addToCart();
            getWebDriver().close();
            getWebDriver().switchTo().window(parentWindow);
        }
        CartPage cartPage = resultPage.goToCart();

        /**
         * Asserting for right products
         */
        ArrayList<String> cartProducts = cartPage.getProductNames();
        Assertions.assertEquals(cartProducts.size(), productNames.size(),
                "Incorrect number of products in cart");

        Collections.sort(productNames);
        Collections.sort(cartProducts);

        for (int index = 0; index < cartProducts.size(); index++) {
            softAssertions.assertThat(productNames.get(index)).as("Product not in cart: " + cartProducts.get(index))
                    .contains(cartProducts.get(index));
        }

        /**
         * checking price
         */
        int totalCartPrice = cartPage.getTotal();
        int totalPrice = 0;
        for (int price : priceList) {
            totalPrice = totalPrice + price;
        }
        softAssertions.assertThat(totalCartPrice).as("Price doesn't match")
                .isGreaterThanOrEqualTo(totalPrice);
    }

    @Test
    public void testAddressValidation(){
        String mailAddress = flipkartHomePage.getMailAddress();
        String officeAddress = flipkartHomePage.getOfficeAddress();

        ContactUsPage contactUsPage = flipkartHomePage.clickContactUs().clickPostalAddress();

        Assertions.assertEquals(mailAddress,contactUsPage.getPostalAddress(),
                "Postal Addresses don't match");

        Assertions.assertTrue(officeAddress.contains(contactUsPage.getCorporateAddress()),
                "Office Addresses don't match");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testDownloadAppTest.csv")
    public void testAppDownloadValidation(String os, String appStoreUrl) {
        AppPage appPage = flipkartHomePage.clickDownloadApp();
        Assertions.assertTrue(appPage.clickOs(os).getUrl().equalsIgnoreCase(appStoreUrl));
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
    }
}