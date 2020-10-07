package web.tests;

import com.codeborne.selenide.*;
import com.training.base.BaseTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.flipkart.CartPage;
import web.pages.flipkart.HomePage;
import web.pages.flipkart.SearchPage;

import java.util.Arrays;

public class FlipkartTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void testSetUp() {
        Selenide.open(map.get("url"));
    }

    /**
     * testSortFilter :In this method shoes selection operation performed by using low to high filter
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/testSortFilter.csv")
    public void testSortFilter(String product, String pagelimit) {
        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");
        for (int page = 1; page <=Integer.parseInt(pagelimit); page++) {
            if (page != 1) {
                searchPage.selectPageNumber(page);
            }
           softAssert.assertThat(searchPage.countingPagePrices()).as("prices list not matching").isTrue();
        }
      logger.info("Assertion working");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addToCartFunctionality.csv")
    public void addToCartFunctionality(String product) {


        String shoenoInString[]= map.get("select_shoe").split(",");
        int[] shoeno = Arrays.asList(shoenoInString).stream().mapToInt(Integer::parseInt).toArray();


        SearchPage searchPage = new HomePage().popUpCancel().setShoes(product).searchShoes().
                sortShoes("Price -- Low to High");

        String[][] productNameAndPrice = new String[shoeno.length][shoeno.length];

/**
 * Getting the product name and price of shoe and storing in array
 */
        for(int row=0;row<shoeno.length;row++){
            for(int col=0;col<2;col++) {
                productNameAndPrice[row][col] = searchPage.getProductName(shoeno[row]);
                col = col+1;
                productNameAndPrice[row][col] =  searchPage.getProductPrice(shoeno[row]);
            }
        }

/**
 * Just printing product Name And Price array
 */
        for(int row=0;row<shoeno.length;row++){
            for(int col=0;col<2;col++) {
                System.out.println("****productNameAndPrice = *** = "+productNameAndPrice[row][col]);
            }
        }

/**
 * Selecting shoe 1 and adding in cart , same procedure for other shoes
 */
        for(int index=0;index<shoeno.length;index++){
            searchPage.OpenProductPage(shoeno[index]).clickShoeSize().addToCartShoe();
            /**
             * If you are selecting last shoe than below if statement will not run, it will not switch to parent window
             */
            if(!((shoeno.length-1)==index)) {
                switchParentWindow();
            }
        }
/**
 * getting ProductName And Price From AddtoCart
 */
        String[][] getProductNameAndPriceFromAddtoCart = new String[shoeno.length][shoeno.length];
        CartPage cartPage = new CartPage();
        for(int row=0;row<shoeno.length;row++){
            for(int col=0;col<2;col++) {
                int z=row+1;
                int c=z+1;
                getProductNameAndPriceFromAddtoCart[row][col] = cartPage.getProductName(z);
                col = col+1;
                getProductNameAndPriceFromAddtoCart[row][col] =  cartPage.getProductPrice(c);
            }
        }

/**
 * Just printing the array and seeing the value
 */
        for(int row=0;row<getProductNameAndPriceFromAddtoCart.length;row++){
            for(int col=0;col<2;col++) {
                System.out.println("****getProductNameAndPriceFromAddtoCart = *** = "+getProductNameAndPriceFromAddtoCart[row][col]);
            }
        }

/**
 * Now comparing 2 array product shoes, not price
 */

        for(int row=0;row<productNameAndPrice.length;row++){

            String singelProductNameAndPriceFromList =   productNameAndPrice[row][0];
            int counter = 0;

            for(int rowToCheckProductInAddToCart=0;rowToCheckProductInAddToCart<getProductNameAndPriceFromAddtoCart.length;counter=rowToCheckProductInAddToCart++) {

                if(getProductNameAndPriceFromAddtoCart[rowToCheckProductInAddToCart][0].contains(singelProductNameAndPriceFromList)){
                    break;
                }

            }
            Assertions.assertFalse(counter==3,"Shoe which was selected from list not found in the cart");
        }


/**
 * Now checking the total price of selected shoe from list
 */
        int totalPriceOfShoeSelectedFromList=0;
        for(int row=0;row<productNameAndPrice.length;row++){
            totalPriceOfShoeSelectedFromList=totalPriceOfShoeSelectedFromList+Integer.parseInt(productNameAndPrice[row][1]);
        }
        softAssert.assertThat(Integer.parseInt(cartPage.getShoePriceTotalInCart())==totalPriceOfShoeSelectedFromList).isTrue();
    }
}