package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    public SelenideElement emailidField = $x("//input[@id='mat-input-0']");
    public SelenideElement passwordField  = $x("//input[@id='mat-input-1']");
    public SelenideElement signInButton = $x("//button[contains(text(),'Sign in')]");
    public SelenideElement popUpTermsandCondition = $x("//button[normalize-space(text()) = 'Accept']");
    public SelenideElement headerName = $x("//h2[contains(text(),'audrey')]");
    public SelenideElement popUpPrivacyPolicy= $x("//button[contains(text(),'Accept')]");
    public LoginPage email(String uid) {
        emailidField.sendKeys(uid);
        return this;
    }

    public LoginPage password() {
        passwordField.sendKeys("Password1");
        return this;
    }

    public LoginPage signIn() {
        signInButton.shouldHave(Condition.visible).click();
        return this;
    }

    public  LoginPage popUpTermsAndCondition() {
        if (isDisplayedWait(popUpTermsandCondition)) {
            popUpTermsandCondition.click();
        }
        return this;
    }
    public  LoginPage popUpPrivacyPolicy() {
        if (isDisplayedWait(popUpPrivacyPolicy)) {
            popUpPrivacyPolicy.click();
        }
        return this;
    }

    public boolean getName(String firstName){
        boolean isTrue = false;
        String name=headerName.getText();
        if(firstName.equals(name)){
            isTrue = true;
        }
        return isTrue;
    }
}