package com.training.web.pages.flipkart;

import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
public class ContactUsPage extends FlipkartBasePage {

    public ContactUsPage clickPostalAddress() {
        $x("//span[text()='Postal Address']").shouldBe(visible).click();
        return this;
    }

    public String getPostalAddress() {
       return  $$x("//div[@class='_14_ipq']").get(1).getText().replaceAll("[, \n]","");
    }

    public String getCorporateAddress() {
        return  $$x("//div[@class='_14_ipq']").get(0).getText().replaceAll("[, \n]","");

    }
}
