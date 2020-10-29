package com.training.web.pages.rccl;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement addCruiseButton= $x("//button[contains(text(),'Add a cruise')]");
    public SelenideElement planNewCruiseButton= $x("//a[contains(text(),'Plan a new cruise')]");
    public SelenideElement APTab= $x("//div[contains(text(),'AP')]");
    public SelenideElement profile= $x("//span[contains(text(),'Profile')]");
    public SelenideElement fullName= $x("//h2[contains(text(),'Audrey Poole')]");


    public HomePage cruiseButton() {
        if (isDisplayedWait(addCruiseButton)) {
            addCruiseButton.shouldHave(Condition.visible);
        }
        return this;
    }

    public HomePage planNewCruiseButton() {
        if (isDisplayedWait(planNewCruiseButton)) {
            planNewCruiseButton.shouldHave(Condition.visible);
        }
        return this;
    }

    public HomePage APTab() {
        APTab.click();
        return this;
    }

    public HomePage profileTab() {
        profile.click();
        return this;
    }

    public boolean getFullName(String ResponseFullName){
        boolean isTrue = false;
        String uiFullName=fullName.getText();
        logger.info(ResponseFullName+"**********response**********");
        logger.info(uiFullName+"************ui********");
        if(uiFullName.equalsIgnoreCase(ResponseFullName)){
            isTrue = true;
        }
        return isTrue;
    }
}