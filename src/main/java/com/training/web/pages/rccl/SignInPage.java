package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SignInPage extends BasePage {

    private SelenideElement singIn = $x("//a[@class='login__create-account login__create-account--royal']");
    private SelenideElement footer = $x("//footer[@class='footer']/ul/li");

    public SignInPage waitForFooterToLoadInSignInPage() {
        footer.shouldBe(Condition.enabled);
        return new SignInPage();
    }

    public CreateAccountPage clickCreateAccountLink() {
        singIn.click();
        return new CreateAccountPage();
    }
}