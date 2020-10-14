package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static SelenideElement setShoes = $x("//form/div/div/input");
    public static SelenideElement searchShoes = $x("//button[@class='vh79eN']");
    public SelenideElement paymentLink = $x("//a[contains(text(),'Payments')]");
    String socialLinkXpath = "//div[text()='SOCIAL']/following-sibling::a[text()='%s']";
    String clickHomePagePolicy = "(//div[@class='_3qd5C5'])[3]/a[text()='%s']";
    ElementsCollection mailUsAddress = $$x("//div[@class='_38DIp6']//p");
    ElementsCollection registeredOfficeAddress = $$x("//div[@class='m6ABEi']//p");
    public SelenideElement contactUs = $x("//a[contains(normalize-space(),'Contact Us')]");


    public HomePage popUpCancel() {
        if (isDisplayedWait(popUpCross)) {
            popUpCross.shouldBe(Condition.visible).click();
        }
        return this;
    }

    public HomePage setShoes(String product) {
        setShoes.sendKeys(product);
        return this;
    }

    public SearchPage searchShoes() {
        searchShoes.shouldBe(Condition.visible).click();
        return new SearchPage();
    }

    public PaymentPage goToPaymentPage() {
        paymentLink.shouldBe(Condition.visible).click();
        return new PaymentPage();
    }

    public SocialMediaPage clickLink(String socialMediaLinks) {
        $x(String.format(socialLinkXpath, socialMediaLinks)).shouldBe(Condition.visible).click();
        return new SocialMediaPage();
    }

    public PolicySubPage clickPolicySingleElement(String policyElementText) {
        String toOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        $x(String.format(clickHomePagePolicy, policyElementText)).sendKeys(toOpenInNewTab);
        Iterator<String> multilpleWindow = getWebDriver().getWindowHandles().iterator();
        String childWindow = null;
        while (multilpleWindow.hasNext()) {
            childWindow = multilpleWindow.next();
        }
        Selenide.switchTo().window(childWindow);
        return new PolicySubPage();
    }

    public String getMailUsAddress() {
        StringBuffer takeMailUsAddress = new StringBuffer();
        for (int i = 0; i < mailUsAddress.size(); i++) {
            takeMailUsAddress.append(mailUsAddress.get(i).getText());
        }
        return (takeMailUsAddress.toString());
    }

    public String getRegisteredOfficeAddress() {
        StringBuffer takeRegisteredOfficeAddress = new StringBuffer();
        for (int i = 0; i < registeredOfficeAddress.size(); i++) {
            takeRegisteredOfficeAddress.append(registeredOfficeAddress.get(i).getText());
        }
        return takeRegisteredOfficeAddress.toString();
    }

    public ContactPage clickContactUS() {
        contactUs.click();
        return new ContactPage();
    }
}