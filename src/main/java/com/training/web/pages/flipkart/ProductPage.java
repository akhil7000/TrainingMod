package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String brandName = "//*[@class='G6XhRU']";
    private String productName = "//*[@class='B_NuCI']";
    private String size = "//*[@id='swatch-0-size']";
    private String cart = "//button[text()='ADD TO CART']";
    private String price = "//div[contains(@class,'_30jeq3')]";
    private String sizeList = "//a[contains(@class,'_1fGeJ5')]";

    public ProductPage clickSize(String shoeSize) {
        String shoeSizeXpath = String.format("//a[text()=%1$s]", shoeSize);
        $x(shoeSizeXpath).shouldBe(Condition.visible).click();
        return this;
    }

    public ProductPage clickFirstAvailableSize() {
        $x(size).shouldBe(Condition.enabled);
        $$x(sizeList).get(0).click();
        return this;
    }

    public CartPage addToCart() {
        $x(cart).shouldBe(Condition.enabled).click();
        waitForLoader();
        logger.info("Added to cart");
        return new CartPage();
    }

    public String getProductName() {
        return $x(brandName).getText() + $x(productName).getText();
    }

    public Integer getProductPrice() {
        return Integer.parseInt($x(price).getText().substring(1));
    }
}