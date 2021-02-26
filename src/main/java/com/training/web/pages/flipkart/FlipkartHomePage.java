package com.training.web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartHomePage extends FlipkartBasePage {

    private SelenideElement searchBox = $x("//input[contains(@title,'Search for products')]");
    private SelenideElement popup = $x("//button[@class='_2KpZ6l _2doB4z']");
    private SelenideElement submit = $x("//button[@class='L0Z3Pu']");


    public FlipkartHomePage closePopup() {
        popup.shouldBe(visible);
        popup.click();
        return this;
    }

    public FlipkartHomePage sendKeysToSearchBox(String keys) {
        searchBox.shouldBe(visible);
        searchBox.sendKeys(keys);
        return this;
    }

    public ResultPage clickSearch() {
        submit.shouldBe(visible).click();
        return new ResultPage();
    }
}