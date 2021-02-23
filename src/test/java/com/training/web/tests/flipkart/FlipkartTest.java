package com.training.web.tests.flipkart;

import com.training.web.pages.flipkart.CartPage;
import com.training.web.pages.flipkart.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.web.pages.flipkart.ResultPage;
import com.training.web.pages.flipkart.FlipkartHomePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws WebDriverException {
        int numberOfPages = 2;

        /**
         * System Property for Chrome Driver
         */
        System.setProperty("webdriver.chrome.driver", "package/resources/chromedriver.exe");

        /**
         * Instantiate a ChromeDriver class.
         */
        ChromeOptions options = new ChromeOptions().addArguments("incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        /**
         * Launch Website and maximise
         */
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /**
         * Close popup and search for shoes
         */
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

        /**
         * Close Chrome
         */
        driver.close();
    }

    @Test
    public void testCartAddition() {

        Integer[] productArray = {2, 3};
        /**
         * System Property for Chrome Driver
         */
        System.setProperty("webdriver.chrome.driver", "package/resources/chromedriver.exe");

        /**
         * Instantiate a ChromeDriver class.
         */
        ChromeOptions options = new ChromeOptions().addArguments("incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        /**
         * Launch Website and maximise
         */
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();

        /**
         * Close popup and search for shoes
         */
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
        Collections.sort(productNames);
        Collections.sort(cartProducts);
        int count = 0;
        for (String cartProductName : cartProducts) {
            if (productNames.contains(cartProductName)) {
                count = 1;
            }
            Assertions.assertEquals(count, 1, "Product not in cart"+String.valueOf(cartProductName));
        }

        /**
         * checking price
         */
        int totalCartPrice = cartPage.getTotal();
        int totalPrice = 0;
        for (int price : priceList) {
            totalPrice = totalPrice + price;
        }
        Assertions.assertEquals(totalPrice, totalCartPrice, "Price doesn't match");
    }
}