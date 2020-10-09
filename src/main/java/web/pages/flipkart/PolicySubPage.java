package web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PolicySubPage {
    String policyPageHeader = "//*[text()='%s']";

    public SelenideElement backToTopButton = $x("//div[@id='container']/div[1]/div[4]/div[1]/span");

    ElementsCollection backToTopButtonTotalSize =$$x("//div[@id='container']/div[1]/div[4]/div[1]/span");
    public SelenideElement scrollDown = $(".HJlsB9");

    public Boolean isHeaderDisplayed(String policyHeader) {
        if($x(String.format(policyPageHeader, policyHeader)).isDisplayed()) {
            return ($x(String.format(policyPageHeader, policyHeader)).shouldHave(Condition.visible)).isDisplayed();
        }
        else {
            return false;
        }
    }
    public Boolean verifyBackToTop() {

        scrollDown.scrollIntoView(false);

        if(backToTopButton.isDisplayed()) {
            backToTopButton.shouldHave(Condition.visible).isDisplayed();
            backToTopButton.click();
            return true;
        }
        else{
            return false;
        }
    }
}
