package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UserAccountPage extends BasePage {
    private SelenideElement lastELementDisplayed = $x("//a[contains(normalize-space(),'Site Map')]");
    private SelenideElement loyalityId = $x("(//ul[@class='loyalty-meter']/li/a/span)[1]");
    private SelenideElement loyalityTier = $x("(//ul[@class='loyalty-meter']/li/a/span)[2]");
    private SelenideElement relationshipPoints = $x("(//ul[@class='loyalty-meter']/li/a/span)[3]");

    public UserAccountPage isUserPageLastElementDisplyed() {
         isDisplayedWait(lastELementDisplayed);
        return this;
    }

    public UserAccountPage refreshPage() {
        Selenide.refresh();
        return this;
    }

    public String getLoyalityIdFromUI(){
        return loyalityId.getText().trim();
    }

    public String getLoyalityTierFromUI(){
        return loyalityTier.getText().trim();
    }

    public String getRelationshipPointsFromUI(){
        return relationshipPoints.getText().trim();
    }
}