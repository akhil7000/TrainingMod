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

    public String clickSocialMediaPage(String media) throws InterruptedException {

        switch (media) {
            case "Facebook":
                SelenideElement facebook = $x("//a[text()='Facebook']");
                facebook.shouldBe(visible).scrollIntoView(true);
                logger.info(facebook.getText());
                facebook.click();
                $x("//u[text()='Facebook']").shouldBe(enabled);
                break;
            case "Twitter":
                SelenideElement twitter = $x("//a[text()='Twitter']");
                twitter.shouldBe(visible).scrollIntoView(true);
                logger.info(twitter.getText());
                twitter.click();
                $x("//a[@aria-label='Twitter']").shouldBe(visible);
                break;
            case "YouTube":
                SelenideElement youtube = $x("//a[text()='YouTube']").shouldBe(visible);
                youtube.shouldBe(visible).scrollIntoView(true);
                logger.info(youtube.getText());
                youtube.click();
                $x("//paper-button[@aria-label='Subscribe']").shouldBe(visible);
                break;
        }
        return driver.getCurrentUrl();
    }
}