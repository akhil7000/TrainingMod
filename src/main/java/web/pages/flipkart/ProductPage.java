package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement clickShoeSize = $x("//li[@id='swatch-0-size']/a");
    public SelenideElement  addToCart = $x("//div[@class='_1k1QCg']/ul/li/button");
    String headersXpath="//*[@id='container']/descendant::div[text()='%s']";
    String spanXpath="//*[@id='container']/descendant::span[text()='%s']";
    public ProductPage clickShoeSize(){
        clickShoeSize.click();
        return this;
    }

    public CartPage addToCartShoe(){
        addToCart.click();
        return new CartPage();
    }

    public boolean isSelectionDisplayed(String headersText) throws InterruptedException {
        logger.info("HeaderText==="+headersText);
        if(headersText.contains("Frequently Bought Together")){
            System.out.println("Frequently Bought **********Together");
            return isDisplayedWait($x(String.format(spanXpath,headersText)));
        }
        if(headersText.contains("Recently Viewed")){
            System.out.println("Recently **********s");
            Thread.sleep(2000);
            return isDisplayedWait($x(String.format(spanXpath,headersText)));
        }

        return isDisplayedWait($x(String.format(headersXpath,headersText)));
    }
}