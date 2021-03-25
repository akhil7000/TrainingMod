package com.training.web.tests.flipkart;

import com.codeborne.selenide.WebDriverRunner;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.AppPage;
import com.training.web.pages.flipkart.FlipkartHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import sun.awt.windows.ThemeReader;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DownloadAppTest extends WebBaseTest {
    FlipkartHomePage flipkartHomePage;
    AppPage appPage;

    @BeforeEach
    public void setup() {
        open("https://www.flipkart.com/");
        flipkartHomePage = new FlipkartHomePage().closePopup();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testDownloadAppTest.csv")
    public void testAppDownloadValidation(String os, String appStoreUrl) {
        appPage = flipkartHomePage.clickDownloadApp();
        Assertions.assertTrue(appPage.clickOs(os).getUrl().equalsIgnoreCase(appStoreUrl));
    }

}