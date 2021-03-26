package com.training.web.pages.flipkart;

import com.training.basepages.FlipkartBasePage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AppPage extends FlipkartBasePage {
    private String parentWindow;
    private String androidApp = "//img[contains(@src,'Play-Store')]";
    private String iosApp= "//img[contains(@src,'App-Store')]";
    private String hassleFreeIcon = "//span[text()='Hassle - free Returns']";

    public AppPage clickOs(String os) {
        parentWindow = getWebDriver().getWindowHandle();
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
        switchToChildWindow(parentWindow);
        return getWebDriver().getCurrentUrl();
    }
}
