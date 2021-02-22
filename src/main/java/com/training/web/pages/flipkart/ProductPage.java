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

    private By brandName = By.className("G6XhRU");
    private By productName = By.className("B_NuCI");
    private By size = By.id("swatch-0-size");
    private By cart = By.xpath("//button[contains(@class,'_2KpZ6l')]");
    private By price = By.xpath("//div[contains(@class,'_30jeq3')]");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ProductPage clickSize(String sS) {
        String shoeSize = sS;
        wait.until(ExpectedConditions.elementToBeClickable(size));
        driver.findElement(By.xpath("//a[text()=" + shoeSize + "]"));
        driver.findElement(size).click();
        return this;
    }

    public CartPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        driver.findElement(cart).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        logger.info("Added to cart");
        return new CartPage(driver);
    }

    public String getProductName() {
        String productFullName = driver.findElement(brandName).getText() + driver.findElement(productName).getText();
        logger.info(productFullName);
        return productFullName;
    }

    public Integer getProductPrice() {
        String pPrice = driver.findElement(price).getText();
        return Integer.parseInt(pPrice.substring(1));
    }
}