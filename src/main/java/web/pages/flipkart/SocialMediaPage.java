package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SocialMediaPage extends BasePage {
    public SelenideElement twitterElementVisible = $x("//span[text()='Settings']");
    public SelenideElement youtubeElementVisible =$x("//div[contains(text(),'Subscriptions')]");
    public SelenideElement facebookElementVisible=$x("//span[text()='About']");

    public String getSocialMediaUrl() {
            return webdriverContainer.getCurrentUrl();
    }
    public void checkFacebookElementVisible(){
        isDisplayedWait(facebookElementVisible);
        //facebookElementVisible.shouldHave(Condition.visible);
    }

    public void checkTwitterElementVisible(){
        isDisplayedWait(twitterElementVisible);
        //twitterElementVisible.shouldHave(Condition.visible);
    }

    public void checkYoutubeElementVisible(){
        isDisplayedWait(youtubeElementVisible);
        //youtubeElementVisible.shouldHave(Condition.visible);
    }
}