package web.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

public class FlipkartTest {
    @BeforeEach
    public void testSetUp(){
        Configuration.timeout=5000;
        Selenide.open("https://www.flipkart.com");
    }

    /**
     *getTestDetails :In this method shoes selection operation performed by using low to high filter
     */
    @Test
    public void testGetDetails()  {
        String product ="shoes";
        String filter="Price -- Low to High";
        int pagelimit=2;
        SearchPage searchPage=new HomePage().popUpCancel().setShoes(product).searchShoes().
                 sortShoes(filter);
               for(int page=1;page<=pagelimit;page++){
                   if(page!=1){
                      searchPage.selectPageNumber(page);
                   }
                   Assertions.assertTrue(searchPage.countingPagePrices(),"prices not matching");
               }
    }
}
