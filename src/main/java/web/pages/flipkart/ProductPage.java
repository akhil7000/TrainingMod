package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement clickShoeSize = $x("//li[@id='swatch-0-size']/a");
    public SelenideElement  addToCart = $x("//div[@class='_1k1QCg']/ul/li/button");
    String headersXpath="//*[@id='container']/descendant::div[text()='%s']";
    //String spanXpath="//*[@id='container']/descendant::span[text()='%s']";
    String spanXpath="//*[@id='container']/descendant::div/span[text()='%s']";
    public SelenideElement scrollDown =$x("//span[text()='Flipkart.com']");

    public void verifyBackToTop(){
      scrollDown.scrollIntoView(false);
    }

    public ProductPage clickShoeSize(){
        clickShoeSize.click();
        return this;
    }

    public CartPage addToCartShoe(){
        addToCart.click();
        return new CartPage();
    }

    public boolean isSelectionDisplayed(String headersText) throws InterruptedException {
        logger.info("HeaderText===" + headersText);
//        if(headersText.contains("Recently Viewed")){
//            System.out.println("bought");
//            return isDisplayedWait($x(String.format(spanXpath,headersText)));
//        }
        return isDisplayedWait($x(String.format(headersXpath,headersText)));
    }
}