package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    public SelenideElement addCruiseButton= $x("//button[contains(text(),'Add a cruise')]");
    public SelenideElement planNewCruiseButton= $x("//a[contains(text(),'Plan a new cruise')]");
    public SelenideElement APTab= $x("//div[contains(text(),'AP')]");

    public HomePage cruiseButton() {
        if (isDisplayedWait(addCruiseButton)) {
           addCruiseButton.shouldHave(Condition.visible);
        }
        return this;
    }

    public HomePage planNewCruiseButton() {
        if (isDisplayedWait(planNewCruiseButton)) {
            planNewCruiseButton.shouldHave(Condition.visible);
        }
        return this;
    }

    public HomePage APTab() {
        APTab.click();
        return this;
    }


}
