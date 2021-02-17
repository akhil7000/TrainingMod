package com.training.web.tests.flipkart;

import com.training.web.pages.flipkart.CartPage;
import com.training.web.pages.flipkart.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.web.pages.flipkart.ResultPage;
import com.training.web.pages.flipkart.FlipkartHomePage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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
            ArrayList<Integer> priceList = resultPage.getPriceInteger();

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
    public void testCartAddition() throws InterruptedException {
        Integer[] products = {7,8};

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
        resultPage.setProductsList();

        for (int i : products) {
            ProductPage productPage= resultPage.clickProduct(i);
            /*Set<String> s = driver.getWindowHandles();
            String childWindow = null;
            Iterator<String> I1 = s.iterator();
            while (I1.hasNext()) {
                if (I1.next() != parentWindow) ;
                childWindow = I1.next();
            }
            driver.switchTo().window(childWindow);*/
            productPage.clickSize();
            productNames.add(productPage.getProductName());
            priceList.add(productPage.getProductPrice());
            productPage.addToCart();
            driver.close();
            driver.switchTo().window(parentWindow);
        }
        resultPage.goToCart();

        /**
         * Asserting for right products
         */
        ArrayList<String> cartProducts = new CartPage(driver).getProductNames();
        int count = 0;
        for (int i = 0; i < cartProducts.size(); i++) {
            String p = cartProducts.get(i);
            for (int j = 0; j < cartProducts.size(); j++) {
                if (productNames.get(j).contains(p)) {
                    count = 1;
                }
            }
            Assertions.assertEquals(count, 1, "Product not in cart");
        }

        /**
         * checking price
         */

        int totalCartPrice = new CartPage(driver).getTotal();
        int totalprice = 0;
        for (int i : priceList) {
            totalprice = totalprice + i;
        }
        Assertions.assertEquals(totalprice, totalCartPrice, "Price doesn't match");
    }
}