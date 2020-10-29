package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    public SelenideElement emailidField = $x("//input[@id='mat-input-0']");
    public SelenideElement passwordField  = $x("//input[@id='mat-input-1']");
    public SelenideElement signInButton = $x("//button[contains(text(),'Sign in')]");
  public SelenideElement popUpAccept = $x("//button[@class='modal-action-button']");
// public SelenideElement popUpAccept = $x("//div[@class='modal__actions confirmation-modal__actions ng-star-inserted']/child::button[normalize-space(text()) = 'Accept']");
    public SelenideElement headerName = $x("//h2[contains(text(),'audrey')]");

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

    public  LoginPage popUpAccept() {
        if (isDisplayedWait(popUpAccept)) {
            //Selenide.switchTo().alert().accept();
            popUpAccept.click();
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
