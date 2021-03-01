package com.training.basepages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FlipkartBasePage {

    private String loaderIcon = "//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']";
    private String cartIcon ="//*[text()='Cart']";
    private NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());

    public void clickCartIcon() {
        $x(cartIcon).click();
    }

    public void waitForLoader() {
        $x(loaderIcon).should(disappear);
    }

    public Integer formatInteger(String number) throws ParseException {
        return numberFormat.parse(number).intValue();
    }
}