package com;

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
import pages.ResultPage;
import pages.FlipkartHomePage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws WebDriverException, InterruptedException {
        ArrayList<Integer> priceList = new ArrayList<>();
        int numberOfPages = 2;

        /**
         * System Property for Chrome Driver
         */
        System.setProperty("webdriver.chrome.driver", "package/resources/chromedriver.exe");

        /**
         *         Instantiate a ChromeDriver class.
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
            List<WebElement> list = resultPage.getShoesPrice();
            logger.info("Size of list" + String.valueOf(list.size()));

            priceList.addAll(resultPage.getPriceInteger(list));
            logger.info("Size of list" + String.valueOf(priceList.size()));

            Assertions.assertEquals(priceList, resultPage.sortPriceList(priceList),
                    "Price not in ascending order in page number" + page);

            if (page != numberOfPages) {
                resultPage.clickNextPage();
            }
        }

        /**
         * Close Chrome
         */
        driver.close();
    }
}