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
    public SelenideElement footer = $(".HJlsB9");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isHeaderDisplayed(String policyHeader) {
        logger.info("Welcome to = " + policyHeader);
        return isDisplayedWait($x(String.format(policyPageHeader, policyHeader)));
    }

    public boolean verifyBackToTop(String policyHeader, String y_Axis_Value) {
        footer.scrollIntoView(false);
        logger.info("================ Before click backToTopButton scroll y height == " + executeJavaScript("return window.pageYOffset;"));

        /**
         * Scroll bar's Y axis should be greater than 1302
         */
        if (Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) >= Integer.parseInt(y_Axis_Value)) {
            if (isDisplayedWait(backToTopButton)) {
                backToTopButton.click();
                isDisplayedWait($x(String.format(policyPageHeader, policyHeader)));

                sleep(2000);
                logger.info("================ After Click backToTopButton == " + executeJavaScript("return window.pageYOffset;"));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean verifyPageGoesUp(String y_Axis_Value) {
        return Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) <=  Integer.parseInt(y_Axis_Value);
    }
}