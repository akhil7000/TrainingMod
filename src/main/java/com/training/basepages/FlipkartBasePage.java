package com.training.basepages;
import com.training.web.pages.flipkart.FlipkartHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FlipkartBasePage extends FlipkartHomePage{
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By cartIcon = By.xpath("//*[text()='Cart']");

    public FlipkartBasePage(WebDriver driver) {
        super(driver);
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    public void waitForLoader(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
    }
}