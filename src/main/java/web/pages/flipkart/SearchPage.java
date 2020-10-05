package web.pages.flipkart;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage{
    ArrayList<Integer> a1;
    ArrayList<Integer> a2;
    public SelenideElement counting_page_wait=$("._2zN0mv");
    ElementsCollection priceList = $$x("//div[@class='_1vC4OE']");
    public SelenideElement sort_shoes_wait=$x("//div[contains(text(),'Newest First')]");
    ElementsCollection sortingfilter = $$x("//div[@class='_3ywJNQ']/div");
    String pageNoElement="//a[@class='_2Xp0TH'][contains(text(),'%s')]";
    String sortShoeElement="//div[@class='_3ywJNQ']/div[%s]";
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public  SearchPage selectPageNumber(int no) {
      $x(String.format(pageNoElement,no)).shouldHave(Condition.visible).click();
        return new SearchPage();
    }

    /**
     * countingPagePrices: performing pagination
     * @return SearchPage
     */
    public Boolean countingPagePrices() {
        a1 = new ArrayList<>();
        a2 = new ArrayList<>();
        counting_page_wait.shouldHave(Condition.disappear);
       Iterator<SelenideElement> iterate_priceList = priceList.iterator();
        while(iterate_priceList.hasNext()){
            String price_without_rupees = iterate_priceList.next().shouldHave(Condition.visible).getText().split("\u20B9")[1];
            a1.add(Integer.parseInt(price_without_rupees.trim()));
        }
        a2=(ArrayList) a1.clone();
        Collections.sort(a2);
        logger.info("a1 = "+a1);
        logger.info("a2 = "+a2);
        logger.info("Size of A1 = "+a1.size());
        logger.info("Size of A2 = "+a2.size());
        return  a1.equals(a2);
    }

    /**
     *
     * @param filter :price filter
     * @return  SearchPage
     */
    public SearchPage sortShoes(String filter) {
        sort_shoes_wait.shouldBe(Condition.visible);
        Iterator<SelenideElement> itTotal = sortingfilter.iterator();
        int count = 0;
        int position = 0;
        while (itTotal.hasNext()) {
            count++;
            if (filter.contains(itTotal.next().getText().trim())) {
                position = count;
                logger.info("position");
               $x(String.format(sortShoeElement,position)).shouldHave(Condition.visible).click();
               break;
            }
        }
        logger.info("position = " + position);
        logger.info(filter);
        return new SearchPage();
    }
}

