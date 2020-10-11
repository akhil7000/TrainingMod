package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage extends BasePage{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement clickShoeSize = $x("//li[@id='swatch-0-size']/a");
    public SelenideElement  addToCart = $x("//div[@class='_1k1QCg']/ul/li/button");
    String headersXpath="//*[@id='container']/descendant::div[text()='%s']";
    public SelenideElement scrollToLoadBottomElement =$x("//span[text()='Flipkart.com']");

    public ProductPage clickShoeSize(){
        clickShoeSize.click();
        return this;
    }

    public CartPage addToCartShoe(){
        addToCart.click();
        return new CartPage();
    }

    public void scrollToBottom(){
        scrollToLoadBottomElement.scrollIntoView(false);
    }

    public boolean isSelectionDisplayed(String headersInSelectionPage){
        logger.info("HeaderText===" + headersInSelectionPage);
        return isDisplayedWait($x(String.format(headersXpath,headersInSelectionPage)));
    }
}