package web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    ArrayList a1 = new ArrayList();
    ArrayList a2 = new ArrayList();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public SearchPage selectPageNumber(int no) {
        $x("//a[@class='_2Xp0TH'][contains(text(),'"+no+"')]").shouldBe(Condition.visible).click();
        logger.info("second page price selected");
        return this;
    }

    public SearchPage countingPagePrices() {
        ElementsCollection priceList = $$x("//div[@class='_1vC4OE']");
        Iterator<SelenideElement> iterate_priceList = priceList.iterator();
        while(iterate_priceList.hasNext()){
            SelenideElement tempPriceList = iterate_priceList.next();
            String singlePriceList = tempPriceList.getText();
            String price_without_rupees = singlePriceList.split("\u20B9")[1];
            a1.add(price_without_rupees);
        }
        a2=(ArrayList) a1.clone();
        Collections.sort(a2);
        logger.info("a1 = "+a1);
        logger.info("a2 = "+a2);
        logger.info("Size of A1 = "+a1.size());
        logger.info("Size of A2 = "+a2.size());
        return  new SearchPage();
    }
}
