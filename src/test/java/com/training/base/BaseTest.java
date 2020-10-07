package com.training.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.training.utilities.GetJsonValue;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import web.pages.flipkart.SearchPage;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    public  Map<String, String> map;
    public SoftAssertions softAssert;
    /**
     * Getting json data and storing it in map variable
     */
    @BeforeEach
    public  void setUp(){
        softAssert=new SoftAssertions();
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        map = (Map) new GetJsonValue().getValue();
        }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
        softAssert.assertAll();
    }
    public void switchParentWindow(){
        Set<String>  handles = getWebDriver().getWindowHandles();
        Iterator<String> multilpleWindow = handles.iterator();
        while(multilpleWindow.hasNext()) {
            Selenide.switchTo().window(multilpleWindow.next());
            break;
        }
    }
}