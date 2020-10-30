package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends BasePage {

    private SelenideElement signIn = $x("//a[@class='login__create-account login__create-account--royal']");

    public CreateAccountPage clickCreateAccountLink() {
        signIn.shouldBe(Condition.visible).click();
        return new CreateAccountPage();
    }
}