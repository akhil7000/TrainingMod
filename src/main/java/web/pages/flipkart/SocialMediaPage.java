package web.pages.flipkart;

import BasePage.BasePage;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SocialMediaPage extends BasePage {
    String placeholdersXpath="//input[@placeholder='%s']";

    public String getSocialMediaUrl() {
        return webdriverContainer.getCurrentUrl();
    }

    public SocialMediaPage checkPlaceholders(String placeholdersOfSocialSites){
        isDisplayedWait($x(String.format(placeholdersXpath,placeholdersOfSocialSites)));
        return this;
    }
}