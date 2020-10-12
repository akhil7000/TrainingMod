package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public boolean verifyBackToTopIsDisplayedAndClickButton(String policyElementsWhichNeedToClick) {
        logger.info("================ String position of scrolling  y axis == " + executeJavaScript("return window.pageYOffset;"));

        if (policyElementsWhichNeedToClick.contains("Sitemap")) {
            return true;
        } else {
            footer.scrollIntoView(false);
            logger.info("================ scrolled done , Before click backToTopButton scroll y axis  == " + executeJavaScript("return window.pageYOffset;"));

            if (policyElementsWhichNeedToClick.contains("Security")) {
                return true;
            } else {
                if (isDisplayedWait(backToTopButton)) {
                    backToTopButton.click();
                    logger.info("================ After Click backToTopButton scroll value == " + executeJavaScript("return window.pageYOffset;"));
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean checkIfBackToTopButtonIsDisapper(String policyElementsWhichNeedToClick) {
        if (policyElementsWhichNeedToClick.contains("Sitemap")) {
            return true;
        } else {
            return isDisplayedWait(backToTopButton);
        }
    }

    public boolean verifyPageGoesUp(String policyElementsWhichNeedToClick) {
        if (policyElementsWhichNeedToClick.contains("Sitemap") || policyElementsWhichNeedToClick.contains("Security")) {
            return true;
        } else {
            int decreaseYaxisFlipkartBar = 16;
            logger.info("********getYaxisValue2************");
            SelenideElement w = $x("//div[@class='_3ybBIU']");
            Dimension weD = w.getSize();//if you want to get the width and Height of the specific element on the webpage then use "getsize()" method.
            Point weP = w.getLocation();//If you want to get the exact "x" and "y" coordinates of the element then use "getLocation()"  method.
            Dimension d = getWebDriver().manage().window().getSize();//getting size of window
            int y_Axis_Value2 = weD.getHeight() + weP.getY();//(speific element height) + (get elememt y cordinate)
            System.out.println("y2 = " + y_Axis_Value2);
            y_Axis_Value2 = y_Axis_Value2 - decreaseYaxisFlipkartBar;
            return Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) <= y_Axis_Value2;
        }
    }
}