package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {
    WebDriver driver;
    By searchBox = By.xpath("//*[@class='_3704LK']");
    By popup = By.xpath("/html/body/div[2]/div/div/button");
    By submit = By.xpath("//*[@class='L0Z3Pu']");

    public FlipkartHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement popup() {
        return driver.findElement(popup);
    }

    public WebElement searchBox() {
        return driver.findElement(searchBox);
    }

    public WebElement submit() {
        return driver.findElement(submit);
    }

}
