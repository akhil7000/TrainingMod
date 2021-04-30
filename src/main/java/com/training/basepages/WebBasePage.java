package com.training.basepages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebBasePage {

    private String loaderIcon = "//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']";
    private String cartIcon ="//*[text()='Cart']";
    private NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
    protected WebDriver driver = WebDriverRunner.getWebDriver();
  
    public void clickCartIcon() {
        $x(cartIcon).click();
    }

    public void waitForLoader() {
        $x(loaderIcon).should(disappear);
    }

    public Integer formatInteger(String number) throws ParseException {
        return numberFormat.parse(number).intValue();
    }

    public boolean isElementVisibile(SelenideElement element) {

        WebDriver driver = element.getWrappedDriver();

        return (Boolean)((JavascriptExecutor)driver).executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);

    }

    public void switchToChildWindow(String parentWindow){
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
    }
}