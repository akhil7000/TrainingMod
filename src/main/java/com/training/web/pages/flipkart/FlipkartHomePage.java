package com.training.web.pages.flipkart;

import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartHomePage extends FlipkartBasePage {
    private String searchBox = "//input[contains(@title,'Search for products')]";
    private String popup = "//button[@class='_2KpZ6l _2doB4z']";
    private String submit = "//button[@class='L0Z3Pu']";
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


    public FlipkartHomePage clickSocialMediaPage(String media) {

        $x(String.format("//a[text()='%s']",media)).shouldBe(visible).scrollIntoView(true).click();

        switch (media) {
            case "Facebook":
                $x(facebookIcon).shouldBe(enabled);
                break;

            case "Twitter":
                $x(twitterIcon).shouldBe(enabled);
                break;

            case "YouTube":
                $x(youtubeIcon).shouldBe(enabled);
                break;

        }
        return this;
    }
}