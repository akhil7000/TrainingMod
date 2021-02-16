package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By totalPrice = By.xpath("//*[@class='Ob17DV _3X7Jj1']");
    private By name = By.xpath("//*[@class='_2Kn22P gBNbID']");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']" +
            "/*[name()='svg']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public ArrayList<String> getProductNames() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        ArrayList<String> productNames = new ArrayList<>();
        List<WebElement> cartList = driver.findElements(name);
        for (WebElement i : cartList) {
            productNames.add(i.getText());
        }
        return productNames;
    }

    public int getTotal() {
        return Integer.parseInt(driver.findElement(totalPrice).getText().substring(1));
    }
}