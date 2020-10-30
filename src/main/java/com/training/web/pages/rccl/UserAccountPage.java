package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UserAccountPage extends BasePage {
    private SelenideElement footer = $x("//div[@class='footer__bottom']/span/div/a");
    private SelenideElement loyaltyId = $x("(//ul[@class='loyalty-meter']/li/a/span)[1]");
    private SelenideElement loyaltyTier = $x("(//ul[@class='loyalty-meter']/li/a/span)[2]");
    private SelenideElement relationshipPoints = $x("(//ul[@class='loyalty-meter']/li/a/span)[3]");

    public UserAccountPage waitForFooterToLoadInUserAccountPage() {
        footer.shouldBe(Condition.enabled);
        return this;
    }

    public String getLoyaltyId() {
        return loyaltyId.getText().trim();
    }

    public String getLoyaltyTier() {
        return loyaltyTier.getText().trim();
    }

    public String getRelationshipPoints() {
        return relationshipPoints.getText().trim();
    }
}