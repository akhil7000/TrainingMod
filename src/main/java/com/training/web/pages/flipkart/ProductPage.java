package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private SelenideElement brandName = $x("//*[@class='G6XhRU']");
    private SelenideElement productName = $x("//*[@class='B_NuCI']");
    private SelenideElement size = $x("//*[@id='swatch-0-size']");
    private SelenideElement cart = $x("//button[text()='ADD TO CART']");
    private SelenideElement price = $x("//div[contains(@class,'_30jeq3')]");
    private ElementsCollection sizeList = $$x("//a[contains(@class,'_1fGeJ5')]");

    public ProductPage clickSize(String shoeSize) {
        String shoeSizeXpath = String.format("//a[text()=%1$s]", shoeSize);
        $x(shoeSizeXpath).shouldBe(Condition.visible).click();
        return this;
    }

    public ProductPage clickFirstAvailableSize() {
        size.shouldBe(Condition.enabled);
        sizeList.get(0).click();
        return this;
    }

    public CartPage addToCart() {
        cart.shouldBe(Condition.enabled);
        cart.click();
        waitForLoader();
        logger.info("Added to cart");
        return new CartPage();
    }

    public String getProductName() {
        return brandName.getText() + productName.getText();
    }

    public Integer getProductPrice() {
        return Integer.parseInt((price).getText().substring(1));
    }
}