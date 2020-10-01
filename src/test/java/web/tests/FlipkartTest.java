package web.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;

public class FlipkartTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp(){
        Configuration.timeout=5000;
        Selenide.open("https://www.flipkart.com");
    }

    /**
     *getTestDetails :In this method shoes selection operation performed by using low to high filter
     */
    @Test
    public void getTestDetails()  {
        String product ="shoes";
        String filter="Price -- Low to High";
        int Pageno=2;
        new HomePage().popUpCancel().setShoes(product).searchShoes().
                 sortShoes(filter).countingPagePrices().selectPageNumber(Pageno).countingPagePrices();
    }
}
