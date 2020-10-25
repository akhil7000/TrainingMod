package com.training.web.pages.flipkart;

import BasePage.BasePage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SocialMediaPage extends BasePage {
    private String placeholdersXpath="//input[@placeholder='%s']";

    public String getSocialMediaUrl(String placeholdersOfSocialSites) {
        isDisplayedWait($x(String.format(placeholdersXpath,placeholdersOfSocialSites)));
        return webdriverContainer.getCurrentUrl();
    }
}