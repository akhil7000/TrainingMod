package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PolicySubPage extends BasePage {
    String policyPageHeader = "//*[text()='%s']";
    public SelenideElement backToTopButton = $x("//div[@id='container']/div[1]/div[4]/div[1]/span");
    public SelenideElement scrollTillButtonAppears = $x("//a[contains(text(),'https://locate.apple.com/in/en')]");
    ElementsCollection backToTopButtonTotalSize = $$x("//div[@id='container']/div[1]/div[4]/div[1]/span");
    public SelenideElement footer = $(".HJlsB9");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Boolean isHeaderDisplayed(String policyHeader) {
        System.out.println("Welcome to = " + policyHeader);
        return isDisplayedWait($x(String.format(policyPageHeader, policyHeader)));

    }

    public Boolean verifyBackToTop() {

        footer.scrollIntoView(false);
//        scrollTillButtonAppears.scrollIntoView(false);

//        System.out.println("================ Before click backToTopButton scroll y height == " + executeJavaScript("return window.pageYOffset;"));
        logger.info("================ Before click backToTopButton scroll y height == " + executeJavaScript("return window.pageYOffset;"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * Scroll bar ka Y axis should be greater than 1302
         */
        if (Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) >= 1302) {

            if (isDisplayedWait(backToTopButton)) {
                backToTopButton.click();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                logger.info("================ After Click backToTopButton == " + executeJavaScript("return window.pageYOffset;"));
//                System.out.println("================ After Click backToTopButton == " + executeJavaScript("return window.pageYOffset;"));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean verifyPageGoesUp() {
        return Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) <= 40;
    }
}