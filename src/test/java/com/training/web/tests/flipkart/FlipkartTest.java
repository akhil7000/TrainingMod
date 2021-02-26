package com.training.web.tests.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.CartPage;
import com.training.web.pages.flipkart.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.web.pages.flipkart.ResultPage;
import com.training.web.pages.flipkart.FlipkartHomePage;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FlipkartTest extends WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testPriceSort() throws WebDriverException {

        int numberOfPages = 2;
        open("https://www.flipkart.com/");
        getWebDriver().manage().window().maximize();

        /**
         * Close popup and search for shoes
         */
        ResultPage resultPage = new FlipkartHomePage().closePopup().sendKeysToSearchBox("shoes")
                .clickSearch().sortLowToHigh();

        /**
         * extracting price and going to next pages for 'n' pages
         */
        for (int page = 1; page <= numberOfPages; page++) {
            ArrayList<Integer> priceList = resultPage.getPrice();

            Assertions.assertEquals(priceList, resultPage.sortPriceList(priceList),
                    "Price not in ascending order in page number " + page);
            if (page != numberOfPages) {
                logger.info("Navigating to page " + String.valueOf(page + 1));
                resultPage.clickNextPage();
            }
        }
    }

    @Test
    public void testCartAddition() {

        Integer[] productArray = {2, 3};

        /**
         * Launch Website and maximise
         */
        open("https://www.flipkart.com/");
        getWebDriver().manage().window().maximize();
        String parentWindow = getWebDriver().getWindowHandle();


        /**
         * Close popup and search for shoes
         */
        ResultPage resultPage = new FlipkartHomePage().closePopup().sendKeysToSearchBox("shoes")
                .clickSearch().sortLowToHigh();

        /**
         * Select and add to cart item 2 and 3
         */
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> priceList = new ArrayList<>();
        List<SelenideElement> productResults = resultPage.getProductsList();

        for (int index : productArray) {
            ProductPage productPage = ResultPage.clickProduct(productResults, index).clickFirstAvailableSize();
            productNames.add(productPage.getProductName());
            priceList.add(productPage.getProductPrice());
            productPage.addToCart();
            getWebDriver().close();
            getWebDriver().switchTo().window(parentWindow);
        }
        CartPage cartPage = resultPage.goToCart();

        /**
         * checking price
         */
        int totalCartPrice = cartPage.getTotal();
        int totalPrice = 0;
        for (int price : priceList) {
            totalPrice = totalPrice + price;
        }
        Assertions.assertTrue(totalCartPrice >= totalPrice, "Price doesn't match");
    }
}