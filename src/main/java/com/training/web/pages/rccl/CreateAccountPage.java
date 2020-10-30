package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage extends BasePage {
    private SelenideElement firstName = $x("(//div[@class='signup__control signup__names ng-star-inserted']//div[@class='mat-form-field-flex']/div[@class='mat-form-field-infix']/input)[1]");
    private SelenideElement LastName = $x("(//div[@class='mat-form-field-infix']/input)[2]");
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CreateAccountPage setFirstName(String givenName) {
        firstName.shouldBe(Condition.visible).sendKeys(givenName);
        return new CreateAccountPage();
    }

    public CreateAccountPage setLastName(String givenLastName) {
        LastName.shouldBe(Condition.visible).sendKeys(givenLastName);
        return new CreateAccountPage();
    }

    public CreateAccountPage selectCountry() {
        countryDropDown.shouldBe(Condition.visible).click();
        selectCountry.shouldBe(Condition.visible).click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setEmail(String userEmail) {
        email.shouldBe(Condition.visible).doubleClick();
        email.sendKeys(userEmail);
        return new CreateAccountPage();
    }

    public CreateAccountPage setPassword(String userPassword) {
        password.shouldBe(Condition.visible).sendKeys(userPassword);
        return new CreateAccountPage();
    }

    public CreateAccountPage setQuestion() {
        questionDropDown.shouldBe(Condition.visible).click();
        selectQuestion.shouldBe(Condition.visible).click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setAnswer(String setAnswer) {
        answer.shouldBe(Condition.visible).sendKeys(setAnswer);
        return new CreateAccountPage();
    }

    public CreateAccountPage clickCheckBox() {
        checkout.shouldBe(Condition.visible).click();
        return new CreateAccountPage();
    }

    public CreateAccountPage setDateofBirth(String dateOfBirth) {
        String dateSplit[] = new String[0];
        try {
            dateSplit = new SimpleDateFormat("yyyy-MM-dd")
                    .format(new SimpleDateFormat("yyyyMMdd")
                            .parse(dateOfBirth)).split("-");
        } catch (ParseException e) {
            logger.info("An exception occurred. ", e);
        }

        dateOfMonthDropDown.shouldBe(Condition.visible).click();
        dateOfBirthMonth.shouldBe(Condition.visible).click();
        dateOfDayDropDown.shouldBe(Condition.visible).click();
        dateOfBirthDay.shouldBe(Condition.visible).click();

        dateOfBirthYear.shouldBe(Condition.visible).sendKeys(dateSplit[0]);

        return new CreateAccountPage();
    }

    public UserAccountPage clickDoneButton() {
        DoneButton.shouldBe(Condition.visible).click();
        return new UserAccountPage();
    }
}