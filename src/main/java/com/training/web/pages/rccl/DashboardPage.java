package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends BasePage {
    private SelenideElement loyaltyId = $x("(//ul[@class='loyalty-meter']/li/a/span)[1]");
    private SelenideElement loyaltyTier = $x("(//ul[@class='loyalty-meter']/li/a/span)[2]");
    private SelenideElement relationshipPoints = $x("(//ul[@class='loyalty-meter']/li/a/span)[3]");

    public String getLoyaltyId() {
        return loyaltyId.shouldBe(Condition.visible).getText().trim();
    }

    public String getLoyaltyTier() {
        return loyaltyTier.shouldBe(Condition.visible).getText().trim();
    }

    public String getRelationshipPoints() {
        return relationshipPoints.shouldBe(Condition.visible).getText().trim();
    }
}