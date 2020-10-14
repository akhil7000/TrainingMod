package web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContactPage {

    public SelenideElement postalAddressLink = $x("//span[@class='_1iY293']//span");
    public SelenideElement corporateAddress = $x("//div[@class='row QTKmAd']//div[1]//div[1]");
    public SelenideElement postalAddress = $x("//div[@class='_2JHRHf']//div[2]//div[1]");

    public ContactPage clickPostalAddress() {
        postalAddressLink.click();
        return this;
    }

    public String getCorporateAddress() {
        return (corporateAddress.getText());
    }

    public String getPostalAddress() {
        return (postalAddress.getText());
    }
}