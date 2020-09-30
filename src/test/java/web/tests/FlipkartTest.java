package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FlipkartTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setUp(){
        Configuration.baseUrl="https://www.flipkart.com";
        Selenide.open("");
    }

    @Test
    public void getDetails()  {
        String product ="shoes";
        String filter="Price -- Low to High";
        System.out.println(product);
        System.out.println(filter);
        HomePage homepage=new HomePage();
        SearchPage searchpage=new SearchPage();
        product=product.trim();
        logger.info(product);
        //to handle popup
        homepage.popUpCancel();
        //to enter product i.e shoes in textfield
        homepage.setShoes(product);
        //to enter search button
        homepage.searchShoes();
        delay();
        //to select low to high filter option
        sortShoes(filter);
        delay();
        //to do the pagination of page1
        counting();//counting prices of page1
        delay();
        //pagination for page2
        searchpage.selectSecondPage();
        delay();
        counting();//counting prices of page2

    }
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
        ArrayList a1 = new ArrayList();
        ArrayList a2 = new ArrayList();
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
    }
    public void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.info("Exception"+e.getMessage());
        }
    }
}
