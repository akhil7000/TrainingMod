package com.training.web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartHomePage extends FlipkartBasePage {
    private String searchBox = "//input[contains(@title,'Search for products')]";
    private String popup = "//button[@class='_2KpZ6l _2doB4z']";
    private String payments = "//a[text()='Payments']";
    private String submit = "//button[@class='L0Z3Pu']";
    private String facebookIcon = "//u[text()='Facebook']";
    private String twitterIcon = "//a[@aria-label='Twitter']";
    private String youtubeIcon = "//paper-button[@aria-label='Subscribe']";
    private String addressBox = "//div[@class='_2WErco row']";
    private String addressList = "//div[@class='_2NKhZn _1U1qnR']";
    private String contactUsLink = "//a[text()='Contact Us']";
    private String moreIcon = "//*[@class='_2gTTdy']";
    private String downloadApp = "//div[text()='Download App']";

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

    public PaymentPage clickPayments() {
        $x(payments).shouldBe(visible).click();
        return new PaymentPage();
    }

    public FlipkartHomePage clickSocialMediaPage(String media) {

        $x(String.format("//a[text()='%s']", media)).shouldBe(visible).click();

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

    public ContactUsPage clickContactUs() {
        $x(contactUsLink).shouldBe(Condition.visible).click();
        return new ContactUsPage();
    }

    public String getMailAddress() {

        $x(addressBox).shouldBe(Condition.visible);
        return  $$x(addressList).get(0).getText().replaceAll("[, \n]","");
    }

    public String getOfficeAddress() {
        $x(addressBox).shouldBe(Condition.visible);
        return  $$x(addressList).get(0).getText().replaceAll("[, \n]","");
    }

    public AppPage clickDownloadApp() {

        $x(moreIcon).shouldBe(enabled).scrollIntoView(true).scrollTo().hover();
        $x(downloadApp).scrollTo().click();
        return new AppPage();
    }
}