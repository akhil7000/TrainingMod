package web.tests;

import com.codeborne.selenide.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.training.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FlipkartTest extends BaseTest {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void testSetUp() {
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Selenide.open(map.get("url"));
    }

    /**
     * getTestDetails :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
//    @MethodSource("values")
    @CsvFileSource(resources = "/Flipkart.csv")
    public void testGetDetails(String product, String pagelimit) {
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

//   public static Stream<Arguments> values() {
//       String[] product = map.get("product1").split(",");
//       String[] pagelimit = map.get("pagelimit1").split(",");
////       logger.info("product");
////       logger.info("pagelimit");
//        return Stream.of(Arguments.of(product, pagelimit), Arguments.of(product,pagelimit));
//    }
}
