package web.pages.flipkart;

import com.codeborne.selenide.WebDriverRunner;

public class SocialMediaPage {

    public String getSocialMediaUrl(){

        return WebDriverRunner.webdriverContainer.getCurrentUrl();
    }
}

