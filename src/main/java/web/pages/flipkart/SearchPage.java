package web.pages.flipkart;

import BasePage.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchPage{
    ArrayList<Integer> a1;
    ArrayList<Integer> a2;
    public SelenideElement counting_page_wait=$("._2zN0mv");
    ElementsCollection priceList = $$x("//div[@class='_1vC4OE']");
    public SelenideElement sort_shoes_wait=$x("//div[contains(text(),'Newest First')]");
    ElementsCollection sortingfilter = $$x("//div[@class='_3ywJNQ']/div");
    String pageNoElement="//a[@class='_2Xp0TH'][contains(text(),'%s')]";
    String sortShoeElement="//div[@class='_3ywJNQ']/div[%s]";
    String  getTextFirstShoe= "(//div[@class='_1vC4OE'])[%s]/parent::div/parent::a/preceding-sibling::a";
    String  clickShoeFromList= "(//div[@class='_1vC4OE'])[%s]/parent::div/parent::a/preceding-sibling::a";
    String getPriceOfshoeFromList= "//div/div/div/div/div/div[2]/div[1]/div[%s]/div[1]/div[1]/a[2]/div[1]/div[1]";

    public SelenideElement clickShoeSize = $x("//li[@id='swatch-0-size']/a");
    public SelenideElement  addToCart = $x("//div[@class='_1k1QCg']/ul/li/button");
    public SelenideElement getTextSecondShoe= $x("(//div[@class='_1vC4OE'])[3]/parent::div/parent::a/preceding-sibling::a");
    public SelenideElement  addToCartShoeOneText= $x("(//div[@class='_3vIvU_']/div/child::a)[1]");
    public SelenideElement  addToCartShoeTwoText = $x("(//div[@class='_3vIvU_']/div/child::a)[2]");
    public SelenideElement addToCartShoePriceOne= $x("//div/div/div/div/div/div/div[2]/div[1]/div[1]/div[1]/span[1]");
    public SelenideElement addToCartShoePriceTwo = $x("//div/div/div/div/div/div/div[3]/div[1]/div[1]/div[1]/span[1]");
    public SelenideElement  addToCartTotalPrice = $x("(//div[@class='hJYgKM']/span)[1]");
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
      counting_page_wait.waitUntil(Condition.disappear,4000);
       Iterator<SelenideElement> iterate_priceList = priceList.iterator();
        while(iterate_priceList.hasNext()){
            String price_without_rupees = iterate_priceList.next().waitUntil(Condition.visible,4000).getText().split("\u20B9")[1];
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
                System.out.println(position);
               $x(String.format(sortShoeElement,position)).shouldHave(Condition.visible).click();
               break;
            }
        }
        logger.info("position = " + position);
        logger.info(filter);
        return new SearchPage();
    }

    /**
     * Getting text of 1st shoe and adding the shoe in cart, same for 2nd shoe
     * @return This
     */
    String firstShoeTextFromList, shoeTowTextFromList;
    public SearchPage doAllOpearation1() {
//         firstShoeTextFromList = getTextFirstShoe.getText();
//        getTextFirstShoe.click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Iterator<String> multilpleWindow = handles.iterator();
        String parentWindow = multilpleWindow.next();
        String childWindow = multilpleWindow.next();
        Selenide.switchTo().window(childWindow);
        clickShoeSize.click();
        addToCart.click();
        /**
         * Switch to parent window and again select 2nd shoe
         */
        Selenide.switchTo().window(parentWindow);
         shoeTowTextFromList = getTextSecondShoe.getText();
//        System.out.println("shoeTowTextFromList = == "+shoeTowTextFromList);
        getTextSecondShoe.click();
        handles = getWebDriver().getWindowHandles();
        multilpleWindow = handles.iterator();

        multilpleWindow.next();
        multilpleWindow.next();
        childWindow = multilpleWindow.next();
        Selenide.switchTo().window(childWindow);
        clickShoeSize.click();
        addToCart.click();
        return this;
    }
    /**
     * Now checking if  the shoes one is present in add to cart page
     */
    public Boolean shoeOnePresentInCart() {
        String addToCartGetShoeOneText = addToCartShoeOneText.getText();
        System.out.println("shoeOneTextFromList = " + firstShoeTextFromList);
        System.out.println("addToCartGetShoeOneText = " + addToCartGetShoeOneText);
        return addToCartGetShoeOneText.contains(firstShoeTextFromList);
    }
    /**
     * Now checking if  the shoes second is present in add to cart page
     */
    public Boolean shoeSecondPresentInCart() {
        String addToCartGetShoeSecondText = addToCartShoeTwoText.getText();
        System.out.println("shoeTowTextFromList = " + shoeTowTextFromList);
        System.out.println("addToCartGetShoeSecondText = " + addToCartGetShoeSecondText);
        return  addToCartGetShoeSecondText.contains(shoeTowTextFromList);
    }

    /**
     * Checking if price of two shoe is same as total
     * @return
     */
    public Boolean checkPriceTotal() {
        String addToCartShoePriceOneText = addToCartShoePriceOne.getText().split("\u20B9")[1];
        String addToCartShoePriceTwoText  =addToCartShoePriceTwo.getText().split("\u20B9")[1];
        String addToCartTotalPriceText =  addToCartTotalPrice.getText().split("\u20B9")[1];
        int Total =Integer.parseInt(addToCartShoePriceOneText)+Integer.parseInt(addToCartShoePriceTwoText);
       int cartTotal = Integer.parseInt(addToCartTotalPriceText);
//        if (Total==cartTotal){
//            System.out.println("*********Yess sameeeeeeeeeeeee*******"+cartTotal);
//        }
        return Total==cartTotal;
    }

    public String getProductName(int position){
      return $x(String.format(getTextFirstShoe,position)).shouldHave(Condition.visible).getText();
    }
    public String getProductPrice(int position){
        return ($x(String.format(getPriceOfshoeFromList,position)).shouldHave(Condition.visible).getText()).split("\u20B9")[1];
    }

    public SearchPage OpenProductPage(int position){
         $x(String.format(clickShoeFromList,position)).shouldHave(Condition.visible).click();
         return this;
    }

    /**
     * Switching to last  window / latest window from parent
     * @return
     */
    Set<String> handles;
    Iterator<String> multilpleWindow;

    public SearchPage windowHandel(){
       handles = getWebDriver().getWindowHandles();
        multilpleWindow = handles.iterator();

        String childWindow = null;
        while(multilpleWindow.hasNext()) {
             childWindow = multilpleWindow.next();
        }
        Selenide.switchTo().window(childWindow);
        return this;
    }


    public SearchPage switchParentWindow(){
        handles = getWebDriver().getWindowHandles();
        multilpleWindow = handles.iterator();
        while(multilpleWindow.hasNext()) {
            Selenide.switchTo().window(multilpleWindow.next());
            break;
        }
        return this;
    }

    public CartPage addToCart(){
        clickShoeSize.click();
        addToCart.click();
        return new CartPage();
    }




}

