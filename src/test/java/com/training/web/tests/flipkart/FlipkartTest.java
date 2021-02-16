package com.training.web.tests.flipkart;

import com.training.web.pages.flipkart.CartPage;
import com.training.web.pages.flipkart.ProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        Integer[] products = {2, 3};

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
        WebDriverWait wait = new WebDriverWait(driver, 30);


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
        ProductPage productPage = new ProductPage(driver);
        resultPage.getProductsList();

        for (int i : products) {
            resultPage.clickProduct(i);
            Set<String> s = driver.getWindowHandles();
            String child_window = null;
            Iterator<String> I1 = s.iterator();
            while (I1.hasNext()) {
                if (I1.next() != parentWindow) ;
                child_window = I1.next();
            }
            driver.switchTo().window(child_window);
            productNames.add(productPage.productName());
            priceList.add(productPage.productPrice());
            productPage.clickSize().addToCart();
            driver.close();
            driver.switchTo().window(parentWindow);
        }
        resultPage.goToCart();

        /**
         * Asserting for right products
         */
        CartPage cartPage = new CartPage(driver);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']/span")));
        ArrayList<String> cartProducts = cartPage.getProductNames();
        int count = 0;
        for (int i = 0; i < cartProducts.size(); i++) {
            String p = cartProducts.get(i);
            for (int j = 0; j < cartProducts.size(); j++) {
                if (productNames.get(j).contains(p)) {
                    count = 1;
                }
            }
            Assertions.assertEquals(count ,1, "Product not in cart");
        }

        /**
         * checking price
         */

        int totalCartPrice = cartPage.getTotal();
        int totalprice = 0;
        for (int i : priceList) {
            totalprice = totalprice + i;
        }
        Assertions.assertEquals(totalCartPrice, totalprice, "Price dont match");
    }
}