package com.training.utilities;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RefreshPageUtility {
    public  void refreshPage(){
        getWebDriver().navigate().refresh();
    }
}
