package web.tests;

import com.codeborne.selenide.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

//
public class FlipkartTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void testSetUp() {
        Configuration.timeout = 5000;
        Configuration.browserCapabilities.setCapability("browserOptions", "--start-maximized, --incognito,--disable-gpu");
        Selenide.open("https://www.flipkart.com");
    }
//    @AfterEach
//    public void tearDown(){
//        Selenide.getW
//    }

    /**
     * getTestDetails :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @MethodSource("values")
    public void testGetDetails(String product, String pagelimit) {
//        int pagelimit=2;
        int pagelimit2 = Integer.parseInt(pagelimit);
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");
        for (int page = 1; page <= pagelimit2; page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
            Assertions.assertTrue(searchPage.countingPagePrices(), "prices not matching");
        }
    }

    public  String  values() {
//]]       return new Object[][]{
////               {"shoes","1"},
////               {"socks","3"}
//
//       };
        String[] product = map.get("product1").split(",");
        String[] pagelimit = map.get("pagelimit1").split(",");
return (product,pagelimit);
    }
    }
//    public String[] values() throws FileNotFoundException {
//        JsonParser jsonParser=new JsonParser();
//       // FileReader reader=new FileReader(Paths.get(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.json");
//        FileReader reader=new FileReader(".\\resources\\Data.json");
//        Object obj=jsonParser.parse(reader);
//        JsonObject fetchdata=(JsonObject) obj;
//        JsonArray dataArray=(JsonArray) fetchdata.get("data");
//        String arr[]=new String[dataArray.size()];
//        for(int i=0;i<dataArray.size();i++){
//            JsonObject items=(JsonObject) dataArray.get(i);
//            String product=(String) items.get("product1");
//            String pagelimit=(String) items.get("pagelimit1");
//            arr[i]=product+","+pagelimit;
//        }
//        return arr;
//    }


