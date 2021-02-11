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
import pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlipkartTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() throws WebDriverException, InterruptedException {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "package/resources/chromedriver.exe");

        // Instantiate a ChromeDriver class.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);
        ArrayList<Integer> priceList = new ArrayList<>();

        // Launch Website and maximise
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Close popup and search for shoes
        FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
        flipkartHomePage.popup().searchBox("shoes").submit().lowToHigh();

        //get all price from page1 to list
        ResultPage resultPage = new ResultPage(driver);
        List<WebElement> list = resultPage.shoePrice();
        logger.info(String.valueOf(list.size()));

        //Extracting price value
        priceList.addAll(resultPage.getPrice(list));
        logger.info(String.valueOf(priceList.size()));

        //Validating if price is in ascending order
        Assertions.assertEquals(priceList, resultPage.sort(priceList), "Price not in ascending order");

        //Switch to next page
        resultPage.next();

        //get all price from page2 to list
        List<WebElement> list2 = resultPage.shoePrice();
        logger.info(String.valueOf(list2.size()));

        // Extracting price values
        logger.info(String.valueOf(list.size()));
        priceList.addAll(resultPage.getPrice(list2));
        logger.info(String.valueOf(priceList.size()));


        //Validating if price is in ascending order
        Assertions.assertEquals(priceList, resultPage.sort(priceList), "Price not in ascending order");

        //Close Chrome
        driver.close();
    }
}