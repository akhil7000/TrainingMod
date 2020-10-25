package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private String addToCartShoeText= "(//div[@class='_3vIvU_']/div/child::a)[%s]";
    private String addToCartShoePrice ="//div/div/div/div/div/div/div[%s]/div[1]/div[1]/div[1]/span[1]";
    private SelenideElement addToCartTotalPrice = $x("(//div[@class='hJYgKM']/span)[1]");

    public String getProductName(int position){
        return $x(String.format(addToCartShoeText,position)).shouldHave(Condition.visible).getText();
    }

    public String getProductPrice(int position){
        return $x(String.format(addToCartShoePrice,position)).shouldHave(Condition.visible).getText().split("\u20B9")[1];
    }

    public String getShoePriceTotalInCart() {
       return addToCartTotalPrice.getText().split("\u20B9")[1];
    }
}