package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage{
    public SelenideElement popUpTermsandCondition = $x("//button[normalize-space(text()) = 'Accept']");
    public SelenideElement headerName = $x("//h2[contains(text(),'audrey')]");
    public SelenideElement popUpPrivacyPolicy= $x("//button[contains(text(),'Accept')]");
    public SelenideElement  clickCruiseButton= $x("//button[contains(text(),'Add a cruise')]");
    public SelenideElement planNewCruiseButton= $x("//a[contains(text(),'Plan a new cruise')]");
    public SelenideElement apTab= $x("//div[contains(text(),'AP')]");
    public SelenideElement profile= $x("//span[contains(text(),'Profile')]");

    public  HomePage popUpTermsAndCondition() {
        popUpTermsandCondition.click();
        return this;
    }

    public  HomePage popUpPrivacyPolicy() {
        popUpPrivacyPolicy.click();
        return this;
    }

    public String getName(){
        return headerName.getText();
    }

    public HomePage clickCruiseButton() {
        clickCruiseButton.shouldHave(Condition.visible);
        return this;
    }

    public HomePage planNewCruiseButton() {
        planNewCruiseButton.shouldHave(Condition.visible);
        return this;
    }

    public HomePage apTab() {
       apTab.click();
        return this;
    }

    public ProfilePage profileTab() {
        profile.click();
        return new ProfilePage();
    }
}