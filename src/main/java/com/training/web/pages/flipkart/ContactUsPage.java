package com.training.web.pages.flipkart;

import com.training.basepages.WebBasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ContactUsPage extends WebBasePage {

    private String postalAddressLink = "//span[text()='Postal Address']";
    private String addressBox = "//div[@class='_14_ipq']";

    public ContactUsPage clickPostalAddress() {
        $x(postalAddressLink).shouldBe(visible).click();
        return this;
    }

    public String getPostalAddress() {
        return $$x(addressBox).get(1).getText().replaceAll("[, \n]", "");
    }

    public String getCorporateAddress() {
        return $$x(addressBox).get(0).getText().replaceAll("[, \n]", "");

    }
}
