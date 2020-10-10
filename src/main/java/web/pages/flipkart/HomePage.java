package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static SelenideElement setShoes = $x("//form/div/div/input");
    public static SelenideElement searchShoes = $x("//button[@class='vh79eN']");
    public SelenideElement paymentLink = $x("//a[contains(text(),'Payments')]");
    String clickHomePagePolicy = "(//div[@class='_3qd5C5'])[3]/a[text()='%s']";

    public HomePage popUpCancel(){
        if(isDisplayedWait(popUpCross)){
            popUpCross.shouldBe(Condition.visible).click();
        }
        return this;
    }
    public HomePage setShoes(String product){
        setShoes.sendKeys(product);
        return this;
    }

    public SearchPage searchShoes(){
        searchShoes.shouldBe(Condition.visible).click();
        return new SearchPage();
    }
    public PaymentPage goToPaymentPage(){
        paymentLink.shouldBe(Condition.visible).click();
        return new PaymentPage();
    }
    public PolicySubPage clickPolicySingleElement(String policyElementText){
        String toOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
         $x(String.format(clickHomePagePolicy, policyElementText)).sendKeys(toOpenInNewTab);
         Iterator<String> multilpleWindow = getWebDriver().getWindowHandles().iterator();
        String childWindow = null;
        while (multilpleWindow.hasNext()) {
            childWindow = multilpleWindow.next();
        }
        Selenide.switchTo().window(childWindow);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new PolicySubPage();
    }
}