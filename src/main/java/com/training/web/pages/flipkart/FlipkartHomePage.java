package com.training.web.pages.flipkart;

import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartHomePage extends FlipkartBasePage {

    private String searchBox = "//input[contains(@title,'Search for products')]";
    private String popup = "//button[@class='_2KpZ6l _2doB4z']";
    private String submit ="//button[@class='L0Z3Pu']";
    private String payments = "//a[text()='Payments']";

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
        $x(payments).scrollIntoView(true).shouldBe(visible).click();
        return new PaymentPage();
    }

}