package com.training.basepages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FlipkartBasePage {
    private SelenideElement loaderIcon = $x("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private SelenideElement cartIcon = $x("//*[text()='Cart']");

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void waitForLoader() {
        loaderIcon.should(disappear);
    }
}