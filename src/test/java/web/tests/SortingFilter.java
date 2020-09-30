package web.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static com.codeborne.selenide.Selenide.*;

public class SortingFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ArrayList a1 = new ArrayList();
    ArrayList a2 = new ArrayList();

    public void sortShoes(String filter) {

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

    }


    public void counting() {
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
        //return a3.equals(a4);

}
}
