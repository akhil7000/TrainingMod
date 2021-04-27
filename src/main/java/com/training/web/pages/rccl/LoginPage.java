package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private String email = "//input[@aria-label='Email address or username']";
    private String password = "//input[@aria-label='Password']";
    private String signIn = "//button[text()=' Sign in ']";
    private String errorMessage = "//div[@class='mat-error ng-star-inserted']";
    private String createAccount = "//a[text()='Create an account']";

    public LoginPage enterEmail(String emailId) {
        $x(email).shouldBe(Condition.visible).sendKeys(emailId);
        return this;
    }

    public LoginPage enterPassword(String passwordText) {
        $x(password).shouldBe(Condition.visible).sendKeys(passwordText);
        return this;
    }

    public HomePage clickSignIn() {
        $x(signIn).shouldBe(Condition.visible).click();
        return new HomePage();
    }

    public String getErrorText() {
        return $x(errorMessage).shouldBe(Condition.visible).getText();
    }

    public CreateAccount createAccount() {
        $x(createAccount).shouldBe(Condition.visible).click();
        return new CreateAccount();
    }
}
