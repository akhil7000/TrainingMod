package com;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        ArrayList<Integer>priceList= new ArrayList<>();

        // Launch Website and maximise
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Close popup
        FlipkartHomePage fph = new FlipkartHomePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(fph.popup()));
        fph.popup().click();

        //Search Shoes
        wait.until(ExpectedConditions.visibilityOf(fph.searchBox()));
        fph.searchBox().sendKeys("shoes");
        fph.submit().click();

        //Sort low to high
        ShoesResultPage srp = new ShoesResultPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(srp.low()));
        srp.low().click();

        //get all price from page1 to list
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(srp.loader())));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='_2YsvKq _3bgaUQ']" +
                "/*[name()='svg']")));
        List<WebElement> list = srp.shoePrice();

        logger.info(String.valueOf(list.size()));

        //Extracting price value
        priceList.addAll(srp.getPrice(list));
        logger.info(String.valueOf(priceList.size()));

        //Switch to next page
        wait.until(ExpectedConditions.elementToBeClickable(srp.next()));
        srp.next().click();

        //get all price from page2 to list
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(srp.loader())));
        List<WebElement> list2 = srp.shoePrice();
        logger.info(String.valueOf(list2.size()));

        // Extracting price values
        logger.info(String.valueOf(list.size()));
        priceList.addAll(srp.getPrice(list2));
        logger.info(String.valueOf(priceList.size()));

        //Sort price arraylist

        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        logger.info("Price sorted");

        //Validating if price is in ascending order

        //Assertions.assertEquals(sortedPrice,price,"Not in ascending Order");

        //Close Chrome
        driver.close();
    }
}