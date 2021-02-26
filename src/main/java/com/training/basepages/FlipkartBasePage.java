package com.training.basepages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FlipkartBasePage {

    private String loaderIcon = "//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']";
    private String cartIcon ="//*[text()='Cart']";

    public void clickCartIcon() {
        $x(cartIcon).click();
    }

    public void waitForLoader() {
        $x(loaderIcon).should(disappear);
    }
}