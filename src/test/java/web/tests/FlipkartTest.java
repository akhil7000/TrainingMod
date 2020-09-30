package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.Page;

public class FlipkartTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Page page=new Page();
    SortingFilter sortfilter=new SortingFilter();
    @BeforeEach
    public void setUp(){
        Configuration.baseUrl="https://www.flipkart.com";
        Selenide.open("");
    }

    @Test
    public void sampleTest() throws Exception {
        Assertions.assertTrue(getDetails());
    }
    public Boolean test1(String product,String filter) throws Exception {
        product=product.trim();
        logger.info(product);
        //to handle popup
        page.popUpCancel();
        //to enter product i.e shoes in textfield
        page.setShoes(product);
        //to enter search button
        page.searchShoes();
        Thread.sleep(5000);
        //to select low to high filter option
        sortfilter.sortShoes(filter);//price low to high
        Thread.sleep(5000);
        //to do the pagination of page1
        sortfilter.counting();//counting prices of page1
        sortfilter.counting();//counting prices of page2
        page.selectSecondPage();
        return true;
    }

    public Boolean getDetails() throws Exception {
        String product ="shoes";
        String filter="Price -- Low to High";
        return test1(product,filter);
    }

}
