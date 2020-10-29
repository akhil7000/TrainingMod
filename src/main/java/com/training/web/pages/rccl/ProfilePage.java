package com.training.web.pages.rccl;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public SelenideElement uiFullName= $x("//h2[contains(text(),'Audrey Poole')]");

    public String getUiFullName(){
        return uiFullName.getText();
    }
}