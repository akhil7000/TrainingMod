package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;
import java.util.Map;

public class FlipkartTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp(){
        Configuration.timeout=5000;
        Selenide.open("https://www.flipkart.com");
    }
//    @AfterEach
//    public void tearDown(){
//        Selenide.getW
//    }

    /**
     *getTestDetails :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @MethodSource("values")
    public void testGetDetails(String product,String filter) {
        System.out.println(product + " "+ filter);
        int pagelimit=2;
        SearchPage searchPage=new HomePage().popUpCancel().setShoes(product).searchShoes().
                 sortShoes("Price -- Low to High");
               for(int page=1;page<=pagelimit;page++){
                   if(page!=1){
                      searchPage.selectPageNumber(page);
                   }
                   Assertions.assertTrue(searchPage.countingPagePrices(),"prices not matching");
               }
    }
    private static Object[] values(){
        return new Object[][]{
                {"shoes","1"},
                {"socks","3"},
        };
    }
}
