package com.training.web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartHomePage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String searchBox = "//input[contains(@title,'Search for products')]";
    private String popup = "//button[@class='_2KpZ6l _2doB4z']";
    private String submit = "//button[@class='L0Z3Pu']";
    private String facebookLink = "//a[text()='Facebook']";
    private String twitterLink = "//a[text()='Twitter']";
    private String youtubeLink = "//a[text()='YouTube']";
    private String facebookIcon = "//u[text()='Facebook']";
    private String twitterIcon = "//a[@aria-label='Twitter']";
    private String youtubeIcon = "//paper-button[@aria-label='Subscribe']";


    public FlipkartHomePage closePopup() {
        $x(popup).shouldBe(visible).click();
        return this;
    }

    public FlipkartHomePage sendKeysToSearchBox(String keys) {
        $x(searchBox).shouldBe(visible).sendKeys(keys);
        return this;
    }

    public ResultPage clickSearch() {
        $x(submit).shouldBe(visible).click();
        return new ResultPage();
    }


    public String clickSocialMediaPage(String media) {

        switch (media) {
            case "Facebook":
                SelenideElement facebook = $x(facebookLink);
                click(facebook);
                $x(facebookIcon).shouldBe(enabled);
                break;
            case "Twitter":
                SelenideElement twitter = $x(twitterLink);
                click(twitter);
                $x(twitterIcon).shouldBe(visible);
                break;
            case "YouTube":
                SelenideElement youtube = $x(youtubeLink).shouldBe(visible);
                click(youtube);
                $x(youtubeIcon).shouldBe(visible);
                break;
        }
        return driver.getCurrentUrl();
    }

    private void click(SelenideElement mediaElement) {
        mediaElement.shouldBe(visible).scrollIntoView(true);
        logger.info(mediaElement.getText());
        mediaElement.click();
    }
}