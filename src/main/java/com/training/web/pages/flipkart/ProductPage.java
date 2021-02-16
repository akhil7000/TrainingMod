package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;
    private WebDriverWait wait;

    private By productName1 = By.xpath("//*[@class='G6XhRU']");
    private By name = By.className("B_NuCI");
    private By size = By.xpath("//*[text()='6']");
    private By cart = By.xpath("//*[@class='_2KpZ6l _2U9uOA _3v1-ww']");
    private By price = By.xpath("//*[@class='_30jeq3 _16Jk6d']");

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ProductPage clickSize() {
        wait.until(ExpectedConditions.elementToBeClickable(size));
        driver.findElement(size).click();
        return this;
    }

    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        driver.findElement(cart).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cart));
        logger.info("Added to cart");
        return this;
    }

    public String productName() {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        String productName = driver.findElement(productName1).getText()
                + driver.findElement(name).getText();
        logger.info(productName);
        return productName;
    }

    public Integer productPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        String Price = driver.findElement(price).getText();
        int productPrice = Integer.parseInt(Price.substring(1));
        logger.info(String.valueOf(productPrice));
        return productPrice;
    }
}