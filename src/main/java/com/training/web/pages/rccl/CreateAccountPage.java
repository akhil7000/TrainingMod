package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage extends BasePage {
    private SelenideElement firstName = $x("(//div[@class='mat-form-field-infix']/input)[1]");
    private SelenideElement LastName = $x("(//div[@class='mat-form-field-infix']/input)[2]");
    private SelenideElement privacyPolicy = $x("//a[@id='privacy-link']");
    private SelenideElement dateOfMonthDropDown = $x("//mat-select[@id='mat-select-0']//div[@class='mat-select-arrow']");
    private SelenideElement dateOfBirthMonth = $x("//span[contains(normalize-space(),'August')]");
    private SelenideElement dateOfDayDropDown = $x("//mat-select[@id='mat-select-1']//div[@class='mat-select-arrow']");
    private SelenideElement dateOfBirthDay = $x("//mat-option[@id='mat-option-13']//span[@class='mat-option-text'][contains(normalize-space(),'2')]");
    private SelenideElement dateOfBirthYear = $x("(//div[@class='mat-form-field-infix']/input)[3]");
    private SelenideElement countryDropDown = $x("//mat-select[@id='mat-select-2']//div[@class='mat-select-arrow']");
    private SelenideElement selectCountry = $x("//span[contains(normalize-space(),'United States of America')]");
    private SelenideElement email = $x("(//div[@class='mat-form-field-infix']/input)[4]");
    private SelenideElement password = $x("(//div[@class='mat-form-field-infix']/input)[5]");
    private SelenideElement questionDropDown = $x("//mat-select[@id='mat-select-3']//div[@class='mat-select-arrow']");
    private SelenideElement selectQuestion = $x("//span[contains(normalize-space(),'Where did you take your first vacation?')]");
    private SelenideElement answer = $x("(//div[@class='mat-form-field-infix']/input)[6]");
    private SelenideElement checkout = $x("//div[@class='input-checkbox__container']/mat-checkbox/label");
    private SelenideElement DoneButton = $x("//button[@class='mat-royal-button btn-create']");

    public CreateAccountPage isPrivacyPolicyVisible() {
        privacyPolicy.shouldBe(Condition.visible);
        return new CreateAccountPage();
    }

    public CreateAccountPage setFirstName(String givenName) {
        firstName.sendKeys(givenName);
        return new CreateAccountPage();
    }

    public CreateAccountPage setLastName(String givenLastName) {
        LastName.sendKeys(givenLastName);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickDateOfMonthDropDown() {
        dateOfMonthDropDown.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setDateOfBirthMonth() {
        dateOfBirthMonth.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage clickDateOfDayDropDown() {
        dateOfDayDropDown.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setDateOfBirthDay() {
        dateOfBirthDay.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setDateOfYear(String year) {
        dateOfBirthYear.sendKeys(year);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickCountryDropDown() {
        countryDropDown.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage selectCountry() {
        selectCountry.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setEmail(String userEmail) {
        email.doubleClick();
        email.sendKeys(userEmail);
        return new CreateAccountPage();
    }

    public CreateAccountPage setPassword(String userPassword) {
        password.sendKeys(userPassword);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickQuestionDropDown() {
        questionDropDown.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setQuestion() {
        selectQuestion.click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setAnswer(String setAnswer) {
        answer.sendKeys(setAnswer);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickCheckBox() {
        checkout.click();
        return new CreateAccountPage();
    }

    public UserAccountPage clickDoneButton() {
        DoneButton.click();
        return new UserAccountPage();
    }
}