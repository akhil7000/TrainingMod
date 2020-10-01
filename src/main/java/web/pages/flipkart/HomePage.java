package web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SelenideElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static SelenideElement setShoes = $x("//form/div/div/input");
    public static SelenideElement searchShoes = $x("//button[@class='vh79eN']");

    public HomePage popUpCancel(){
        popUpCross.shouldBe(Condition.visible).click();
        return this;
    }
    public HomePage setShoes(String product){
        setShoes.sendKeys(product);
        return this;
    }
    public HomePage searchShoes(){
        searchShoes.shouldBe(Condition.visible).click();
        return this;
    }
    public SearchPage sortShoes(String filter) {
       $x("//div[contains(text(),'Newest First')]").shouldBe(Condition.visible);
        ElementsCollection sortingfilter = $$x("//div[@class='_3ywJNQ']/div");
        Iterator<SelenideElement> itTotal = sortingfilter.iterator();
        int count = 0;
        int position = 0;
        while (itTotal.hasNext()) {
            count++;
            String temp = itTotal.next().getText();
            temp = temp.trim();
            if (filter.contains(temp)) {
                position = count;
                $x("//div[@class='_3ywJNQ']/div[" + position + "]").click();
            }
            logger.info("temp = " + temp);
        }
        logger.info("position = " + position);
        logger.info(filter);
        return new SearchPage();
    }



}
