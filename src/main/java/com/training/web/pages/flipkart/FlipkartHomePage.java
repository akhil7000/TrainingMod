package com.training.web.pages.flipkart;

import com.training.basepages.FlipkartBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage extends FlipkartBasePage {


    private By searchBox = By.xpath("//input[contains(@title,'Search for products')]");
    private By popup = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    private By submit = By.xpath("//button[@class='L0Z3Pu']");

    public FlipkartHomePage(WebDriver driver) {
        super(driver);
    }

    public FlipkartHomePage closePopup() {
        wait.until(ExpectedConditions.elementToBeClickable(popup));
        driver.findElement(popup).click();
        return this;
    }

    public FlipkartHomePage sendKeysToSearchBox(String keys) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).sendKeys(keys);
        return this;
    }

    public ResultPage clickSearch() {
        driver.findElement(submit).click();
        return new ResultPage(driver);
    }
}