package com.training.web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;

public class PolicySubPage extends BasePage {
    String policyPageHeader = "//*[text()='%s']";
    public SelenideElement backToTopButton = $(".kxUxS5._2eElCl span");
    public SelenideElement backToTopButtonDisappear = $x("//div[@class='kxUxS5']");
    public SelenideElement footer = $(".HJlsB9");
    public SelenideElement getMinimumYaxisOfPage = $x("//div[@class='_3ybBIU']");

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean isHeaderDisplayed(String policyHeader) {

        logger.info("Welcome to = " + policyHeader);
        return isDisplayedWait($x(String.format(policyPageHeader, policyHeader)));

    }

    public boolean scrollPageToFooter() {
        if (!isDisplayedWait(footer)) {
            return false;
        } else {
            footer.scrollIntoView(false);
            return true;
        }
    }

    public boolean clickBackToTopButton(String policy) {
        if (policy.contains("Security")) {
            return true;
        } else {
            if (isDisplayedWait(backToTopButton)) {
                backToTopButton.click();
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkIfBackToTopButtonIsDisapperAndverifyPageGoesUp(String policy) {
        if (policy.contains("Security")) {
            return true;
        } else {
            /**
             * Checking if back to top button is dissapear
             */
            if (isDisplayedWait(backToTopButtonDisappear)) {
                int decreaseYaxisFlipkartBar = 16;
                logger.info("********getYaxisValue2************");
                /**
                 * Sitemap getMinimumYaxisOfPage is not there, new page gets open
                 */
                if (isDisplayedWait(getMinimumYaxisOfPage)) {
                    Dimension weD = getMinimumYaxisOfPage.getSize();//if you want to get the width and Height of the specific element on the webpage then use "getsize()" method.
                    Point weP = getMinimumYaxisOfPage.getLocation();//If you want to get the exact "x" and "y" coordinates of the element then use "getLocation()"  method.
                    int y_Axis_Value2 = weD.getHeight() + weP.getY();//(speific element height) + (get elememt y cordinate)
                    System.out.println("y2 = " + y_Axis_Value2);
                    y_Axis_Value2 = y_Axis_Value2 - decreaseYaxisFlipkartBar;
                    return Integer.parseInt(executeJavaScript("return window.pageYOffset;").toString()) <= y_Axis_Value2;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}