package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$x;

public class CreateAccount {
    String firstNameBox = "//input[@aria-label='First name/Given name']";
    String lastNameBox = "//input[@aria-label='Last name/Surname']";
    String emailIdBox = "//input[@aria-label='Email address']";
    String passwordTextBox = "//input[@aria-label='Create new password']";
    String monthDropDown = "//span[text()='Month']";
    String month = "//span[text()=' %s ']";
    String day = "//span[text()=' %s ']";
    String dayDropDown = "//span[text()='Day']";
    String year = "//input[@aria-label='Year']";
    String countryDropDown = "(//span[text()='Country/Region of residence'])[1]";
    String country = "//span[text()=' %s ']";
    String securityQuestionDropDown = "//div[@class='mat-select-arrow ng-tns-c51-22']";
    String securityQuestionOption = "//span[text()=' %s ']";
    String securityAnswerBox = "//input[@aria-label='Answer']";
    String acceptPolicy = "//label[@class='mat-checkbox-layout']";
    String doneButton = "//button[text()=' Done ']";

    public CreateAccount enterIdAndPassword(String mail, String password) {
        $x(passwordTextBox).shouldBe(Condition.visible).sendKeys(password);
        $x(emailIdBox).shouldBe(Condition.visible).click();
        $x(emailIdBox).sendKeys(mail);
        return this;
    }

    public CreateAccount enterName(String firstName, String lastName) {
        $x(firstNameBox).shouldBe(Condition.visible).sendKeys(firstName);
        $x(lastNameBox).shouldBe(Condition.visible).sendKeys(lastName);
        return this;
    }

    public CreateAccount enterDateOfBirth(String monthString,String dayString, String yearString){

        $x(monthDropDown).shouldHave(Condition.text(" Month ")).shouldBe(Condition.visible).click();
        $x(String.format(month,monthString)).shouldBe(Condition.visible).click();
        $x(dayDropDown).shouldBe(Condition.visible).click();
        $x(String.format(day,dayString)).shouldBe(Condition.visible).click();
        $x(year).shouldBe().sendKeys(yearString);
        return this;
    }

    public CreateAccount selectCountry(String countryName) {
        $x(countryDropDown).shouldBe(Condition.visible).click();
        $x(String.format(country,countryName)).shouldBe().click();
        return this;
    }

    public CreateAccount enterSecurityQuestion(String securityQuestion, String securityAnswer) {
        $x(securityQuestionDropDown).shouldBe(Condition.visible).click();
        $x( String.format(securityQuestionOption,securityQuestion)).shouldBe(Condition.visible).click();
        $x( securityAnswerBox).shouldBe(Condition.visible).sendKeys(securityAnswer);
        return this;
    }

    public CreateAccount acceptTerms() {
        $x(acceptPolicy).shouldBe(Condition.visible).click();
        return this;
    }

    public HomePage clickDone() {
        $x(doneButton).shouldBe(Condition.visible).click();
        return new HomePage();
    }
}
