package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By totalPrice = By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]" +
            "/div/div/div/div[4]/div/span/div/div/span");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public ArrayList<String> getProductNames() {
        ArrayList<String> productNames=new ArrayList<>();
        List<WebElement>  cartList= driver.findElements(By.xpath("//*[@class='_2Kn22P gBNbID']"));
        for(WebElement i:cartList){
            productNames.add(i.getText());
        }
        return productNames;
    }

    public int getTotal() {
        int total = Integer.parseInt(driver.findElement(totalPrice).getText().substring(1));
        return total;
    }
}
