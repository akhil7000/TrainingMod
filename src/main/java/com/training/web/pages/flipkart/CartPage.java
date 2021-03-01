package com.training.web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends FlipkartBasePage {

    private String totalPrice = "//*[contains(@class,'_3X7Jj1')]";
    private String name = "//a[contains(@class,'gBNbID')]";
    private String placeOrderButton = "//*[text()='Place Order']";

    public ArrayList<String> getProductNames() {

        $x(placeOrderButton).shouldBe(visible);
        ArrayList<String> productNames = new ArrayList<>();
        for (SelenideElement index : $$x(name)) {
            productNames.add(index.getText());
        }
        return productNames;
    }

    public int getTotal() throws ParseException {
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        String total = $x(totalPrice).shouldBe(visible).getText().substring(1);
        return nf.parse(total).intValue();
    }
}