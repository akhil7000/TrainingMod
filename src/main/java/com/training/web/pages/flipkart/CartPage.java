package com.training.web.pages.flipkart;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import java.util.ArrayList;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends FlipkartBasePage {

    private SelenideElement totalPrice = $x("//*[contains(@class,'_3X7Jj1')]");
    private ElementsCollection name = $$x("//a[contains(@class,'gBNbID')]");
    private SelenideElement placeOrderButton = $x("//*[text()='Place Order']");

    public ArrayList<String> getProductNames() {

        placeOrderButton.shouldBe(appear);
        ArrayList<String> productNames = new ArrayList<>();
        for (SelenideElement index : name) {
            productNames.add(index.getText());
        }
        return productNames;
    }

    public int getTotal() {

        totalPrice.shouldBe(visible);
        return Integer.parseInt(totalPrice.getText().substring(1));
    }

}