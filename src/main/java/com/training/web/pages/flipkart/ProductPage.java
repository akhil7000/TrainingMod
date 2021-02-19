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

    private By productName1=By.className("G6XhRU");
    private By name = By.className("B_NuCI");
    private By size=By.id("swatch-0-size");
    private By cart = By.xpath("//button[contains(@class,'_2KpZ6l')]");
    private By price= By.xpath("//div[contains(@class,'_30jeq3')]");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        logger.info("Added to cart");
        return this;
    }

    public String getProductName() {
        String productName = driver.findElement(productName1).getText()
                + driver.findElement(name).getText();
        logger.info(productName);
        return productName;
    }

    public Integer getProductPrice()throws NumberFormatException {
        String pPrice = driver.findElement(price).getText().trim();
        logger.info(pPrice);
        /*int index=pPrice.indexOf("₹");
        int productPrice = Integer.parseInt(pPrice.substring(index)+1);*/
        int productPrice = Integer.parseInt(pPrice.substring(1));
        logger.info(String.valueOf(productPrice));
        return productPrice;
    }
}