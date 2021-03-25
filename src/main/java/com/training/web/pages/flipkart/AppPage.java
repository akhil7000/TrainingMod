package com.training.web.pages.flipkart;

import java.util.Iterator;
import java.util.Set;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AppPage {
    private String parentWindow=getWebDriver().getWindowHandle();
    private String androidApp = "//img[contains(@src,'Play-Store')]";
    private String iosApp= "//img[contains(@src,'App-Store')]";
    private String hassleFreeIcon = "//span[text()='Hassle - free Returns']";

    public AppPage clickOs(String os) {
        $x(hassleFreeIcon).shouldBe(visible);
        if(os.equalsIgnoreCase("Android")){
            $x(androidApp).click();
        }
        else{
            $x(iosApp).click();
        }
        return this;
    }

    public String getUrl(){
        String childWindow = null;

        Set<String> windowHandles = getWebDriver().getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        while (windowIterator.hasNext()) {
            String windows = windowIterator.next();
            if (windows != parentWindow) {
                childWindow = windows;

            }
        }
        getWebDriver().switchTo().window(childWindow);
        return getWebDriver().getCurrentUrl();
    }
}
