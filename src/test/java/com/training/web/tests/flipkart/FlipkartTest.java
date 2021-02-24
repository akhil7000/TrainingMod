package com.training.web.tests.flipkart;

import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.CartPage;
import com.training.web.pages.flipkart.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.web.pages.flipkart.ResultPage;
import com.training.web.pages.flipkart.FlipkartHomePage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartTest extends WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws WebDriverException {
        int numberOfPages = 2;
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        ResultPage resultPage = new FlipkartHomePage(driver).closePopup().sendKeysToSearchBox("shoes")
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
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String parentWindow = driver.getWindowHandle();
        ResultPage resultPage = new FlipkartHomePage(driver).closePopup().sendKeysToSearchBox("shoes")
                .clickSearch().sortLowToHigh();

        /**
         * Select and add to cart item 2 and 3
         */
        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Integer> priceList = new ArrayList<>();

        List<WebElement> productResults = resultPage.getProductsList();
        for (int index : productArray) {
            ProductPage productPage = resultPage.clickProduct(productResults, index).clickFirstAvailableSize();
            productNames.add(productPage.getProductName());
            priceList.add(productPage.getProductPrice());
            productPage.addToCart(driver);
            driver.close();
            driver.switchTo().window(parentWindow);
        }
        CartPage cartPage = resultPage.goToCart(driver);

        /**
         * Asserting for right products
         */
        ArrayList<String> cartProducts = cartPage.getProductNames();
        Assertions.assertEquals(cartProducts.size(), productNames.size(),
                "Incorrect number of products in cart");

        Collections.sort(productNames);
        Collections.sort(cartProducts);

        for (int index = 0; index < cartProducts.size(); index++) {
            Assertions.assertTrue(productNames.get(index).contains(cartProducts.get(index)),
                    "Product not in cart: " + cartProducts.get(index));
        }

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