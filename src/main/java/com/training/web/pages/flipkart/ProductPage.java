package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
    private By sizeList = By.xpath("//a[contains(@class,'_1fGeJ5')]");

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ProductPage clickSize(String shoeSize) {
        String shoeSizeXpath = String.format("//a[text()=%1$s]", shoeSize);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(shoeSizeXpath)));
        driver.findElement(By.xpath(shoeSizeXpath)).click();
        return this;
    }

    public ProductPage clickFirstAvailableSize() {
        wait.until(ExpectedConditions.elementToBeClickable(size));
        driver.findElements(sizeList).get(0).click();
        return this;
    }

    public CartPage addToCart(WebDriver driver) {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        driver.findElement(cart).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        logger.info("Added to cart");
        return new CartPage(driver);
    }

    public String getProductName() {
      return driver.findElement(brandName).getText() + driver.findElement(productName).getText();
    }

    public Integer getProductPrice() {
        return Integer.parseInt((driver.findElement(price).getText()).substring(1));
    }
}