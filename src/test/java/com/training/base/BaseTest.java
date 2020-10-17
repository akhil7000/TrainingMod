package com.training.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Iterator;
import java.util.Map;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    public Map<String, String> map;
    public SoftAssertions softAssert;

    /**
     * Getting json data and storing it in map variable
     */
    @BeforeEach
    public void setUp() {
        softAssert = new SoftAssertions();
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
        softAssert.assertAll();
    }

    /**
     * Switching to parent window, if there are N numbers of shoes  which need to be selected then this below function is call, And if there is only one shoe which needs to be selected then this function we wont call
     */
    public void switchParentWindow() {
        Iterator<String> multilpleWindow = getWebDriver().getWindowHandles().iterator();
        while (multilpleWindow.hasNext()) {
            Selenide.switchTo().window(multilpleWindow.next());
            break;
        }
    }
}