package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement emailIdField = $x("//input[@id='mat-input-0']");
    public SelenideElement passwordField = $x("//input[@id='mat-input-1']");
    public SelenideElement signInButton = $x("//button[contains(text(),'Sign in')]");

    public LoginPage setEmail(String uid) {
        emailIdField.sendKeys(uid);
        return this;
    }

    public LoginPage setPassword() {
        passwordField.sendKeys("Password1");
        return this;
    }

    public HomePage clickSignIn() {
        signInButton.shouldHave(Condition.visible).click();
        return new HomePage();
    }
}