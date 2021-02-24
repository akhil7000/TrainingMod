package com.training.basepages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartBasePage{
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By cartIcon = By.xpath("//*[text()='Cart']");

    public FlipkartBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void waitForLoader(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
    }
}