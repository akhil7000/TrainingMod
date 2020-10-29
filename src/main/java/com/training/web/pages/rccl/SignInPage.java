package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends BasePage {

    private SelenideElement singIn = $x("//a[@class='login__create-account login__create-account--royal']");

    public CreateAccountPage clickLink() {
        isDisplayedWait(singIn);
        singIn.click();
        return new CreateAccountPage();
    }
}