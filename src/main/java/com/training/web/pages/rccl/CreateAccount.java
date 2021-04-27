package com.training.web.pages.rccl;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class CreateAccount {
    String firstNameBox = "//input[@aria-label='First name/Given name']";
    String lastNameBox = "//input[@aria-label='Last name/Surname']";
    String emailIdBox = "//input[@aria-label='Email address']";
    String passwordTextBox = "//input[@aria-label='Create new password']";
    String monthDropDown = "//span[text()='Month']";
    String month = "//span[text()=' August ']";
    String day = "//span[text()=' 2 ']";
    String dayDropDown = "//span[text()='Day']";
    String year = "//input[@aria-label='Year']";
    String countryDropDown = "(//span[text()='Country/Region of residence'])[1]";
    String country = "//span[text()=' United States ']";
    String securityQuestionDropDown = "//div[@class='mat-select-arrow ng-tns-c51-22']";
    String securityQuestion = "//span[text()=' What elementary school did you go to? ']";
    String securityAnswer = "//input[@aria-label='Answer']";
    String acceptPolicy = "//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']";
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

    public CreateAccount enterDateOfBirth() {

        $x(monthDropDown).shouldHave(Condition.text(" Month ")).shouldBe(Condition.visible).click();
        $x(month).shouldBe(Condition.visible).click();
        $x(dayDropDown).shouldBe(Condition.visible).click();
        $x(day).shouldBe(Condition.visible).click();
        $x(year).shouldBe().sendKeys("1962");
        return this;
    }

    public CreateAccount selectCountry() {
        $x(countryDropDown).shouldBe(Condition.visible).click();
        $x(country).shouldBe().click();
        return this;
    }

    public CreateAccount enterSecurityQuestion() {
        $x(securityQuestionDropDown).shouldBe(Condition.visible).click();
        $x(securityQuestion).shouldBe(Condition.visible).click();
        $x(securityAnswer).shouldBe(Condition.visible).sendKeys("Abcdefg");
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
