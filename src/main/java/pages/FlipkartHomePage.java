package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartHomePage {
    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.xpath("//*[@class='_3704LK']");
    By popup = By.xpath("/html/body/div[2]/div/div/button");
    By submit = By.xpath("//*[@class='L0Z3Pu']");

    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
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