package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private String acceptButton = "//button[text()=' Accept ']";
    private String userName = "//h2[@class='hero-header__user-name']";
    private String pastCruises = "//span[text()='Past cruises']";
    private String upComingCruises = "//span[text()='Upcoming cruises']";
    private String addCruise = "//button[text()='Add a cruise']";
    private String planCruise = "//a[text()='Plan a new cruise']";
    private String loyaltyId="//span[@class='loyalty-meter__item-title']";

    public HomePage clickAccept() {
        $x(acceptButton).shouldBe(Condition.visible).click();
        return new HomePage();
    }

    public String getUserName() {
        return $x(userName).shouldBe(Condition.visible)
                .shouldBe(Condition.enabled).getText();
    }

    public boolean isUpcomingCruisesVisible() {
        return $x(upComingCruises).shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isPastCruisesVisible() {
        return $x(pastCruises).shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAddCruiseVisible() {
        return $x(addCruise).shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isPlanNewCruiseVisible() {
        return $x(planCruise).shouldBe(Condition.visible).isDisplayed();
    }

    public String getLoyaltyId() {
        return $x(loyaltyId).shouldBe(Condition.visible).getText();
    }

}