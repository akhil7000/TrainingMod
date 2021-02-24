package com.training.web.pages.flipkart;

import com.training.web.basepages.FlipkartBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends FlipkartBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By totalPrice = By.xpath("//*[contains(@class,'_3X7Jj1')]");
    private By name = By.xpath("//a[contains(@class,'gBNbID')]");
    private By placeOrderButton = By.xpath("//*[text()='Place Order']");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public ArrayList<String> getProductNames() {
        waitForLoader();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        ArrayList<String> productNames = new ArrayList<>();
        List<WebElement> cartList = driver.findElements(name);
        for (WebElement index : cartList) {
            productNames.add(index.getText());
        }
        return productNames;
    }

    public int getTotal() {
        String price = driver.findElement(totalPrice).getText();
        return Integer.parseInt(price.substring(1));
    }
}