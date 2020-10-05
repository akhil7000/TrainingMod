package com.training.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.training.utilities.GetJsonValue;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class BaseTest {
    public static Map<String, String> map;
    public Map<String, String> map;
    public SoftAssertions softAssert;

    /**
     * Getting json data and storing it in map variable
     */
    @BeforeEach
    public  void testSetup(){
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
      map = (Map) new GetJsonValue().getValue();
    }
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();

    public void testSetup(){
        softAssert = new SoftAssertions();
        map = (Map) new GetJsonValue().getValue();
    }
    @AfterEach
    public void tearDown(){
        softAssert.assertAll();
    }
}