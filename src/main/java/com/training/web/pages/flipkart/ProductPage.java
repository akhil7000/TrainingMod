package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductPage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;
    private WebDriverWait wait;
    By name = By.className("B_NuCI");
    By price = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]");

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ProductPage clickSize() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='6']")).click();
        return this;
    }

    public ProductPage addToCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
        logger.info("Added to cart");
        return this;
    }

    public String productName() throws InterruptedException {
        Thread.sleep(1000);
        String productName = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]" +
                "/div[2]/div[2]/div/div[1]/h1/span[1]")).getText() + driver.findElement(name).getText();
        logger.info(productName);
        return productName;
    }

    public Integer productPrice() throws InterruptedException {
        Thread.sleep(2000);
        String Price = driver.findElement(By.xpath("//*[@class='_30jeq3 _16Jk6d']")).getText();
        int productPrice = Integer.parseInt(Price.substring(1));
        logger.info(String.valueOf(productPrice));
        return productPrice;
    }

}
