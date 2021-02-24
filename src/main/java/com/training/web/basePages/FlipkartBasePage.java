package com.training.web.basePages;

import org.openqa.selenium.By;

public class FlipkartBasePage {
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By cartIcon = By.xpath("//*[text()='Cart']");

    public By getCartIcon() {
        return cartIcon;
    }

    public By getLoaderIcon() {
        return loaderIcon;
    }
}