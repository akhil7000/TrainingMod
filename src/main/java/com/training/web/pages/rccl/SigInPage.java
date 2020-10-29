package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SigInPage {

    private SelenideElement singIn = $x("//a[@class='login__create-account login__create-account--royal']");

    public CreateAccountPage clickLink() {
        singIn.shouldBe(Condition.visible).click();
        return new CreateAccountPage();
    }
}