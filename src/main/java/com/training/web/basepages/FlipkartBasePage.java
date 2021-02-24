package com.training.web.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartBasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FlipkartBasePage() {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By cartIcon = By.xpath("//*[text()='Cart']");

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void waitForLoader(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
    }
}