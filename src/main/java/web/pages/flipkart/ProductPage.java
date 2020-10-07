package web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    public SelenideElement clickShoeSize = $x("//li[@id='swatch-0-size']/a");
    public SelenideElement  addToCart = $x("//div[@class='_1k1QCg']/ul/li/button");

    public ProductPage clickShoeSize(){
        clickShoeSize.click();
        return this;
    }
    public ProductPage addToCartShoe(){
        addToCart.click();
        return this;
    }
}
