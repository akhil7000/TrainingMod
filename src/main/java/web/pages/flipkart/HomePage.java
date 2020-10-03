package web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static SelenideElement setShoes = $x("//form/div/div/input");
    public static SelenideElement searchShoes = $x("//button[@class='vh79eN']");

    public HomePage popUpCancel(){
        if(popUpCross.isDisplayed()) {
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
}
