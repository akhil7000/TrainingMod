package com.training.web.pages.flipkart;

import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ResultPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String lowToHigh = "//*[text()='Price -- Low to High']";
    private String productResults = "//img[contains(@class,'_2r_T1I')]";
    private String shoesPrice = "//*[@class='_30jeq3']";
    private String nextPageButton = "//*[text()='Next']";
    private String sortBy = "//*[@class='_10Ermr']";

    public ResultPage sortLowToHigh() {

        waitForLoader();
        $x(lowToHigh).shouldBe(visible).click();
        return this;
    }

    public List<SelenideElement> getPriceElements() {
        $x(nextPageButton).shouldBe(exist);
        List<SelenideElement> list= $$x(shoesPrice);
        logger.info("Size of list"+list.size());
        return list;
    }

    public ArrayList<Integer> getPrice() throws ParseException {

        $x(nextPageButton).shouldBe(exist);
        ArrayList<Integer> priceList= new ArrayList<>();
        for (SelenideElement listItem:getPriceElements()){
            String priceString = listItem.getText().substring(1);
            priceList.add(formatInteger(priceString));
        }
        return priceList;
    }

    public ResultPage clickNextPage() {

        $x(nextPageButton).shouldBe(visible).click();
        return this;
    }

    public ArrayList<Integer> sortPriceList(ArrayList<Integer> priceList) {

        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        return sortedPrice;
    }

    public List<SelenideElement> getProductsList() {

        $x(nextPageButton).shouldBe(visible);
        return $$x(productResults);
    }

    public ProductPage clickProduct(List<SelenideElement> productList, int itemNumber) {

        $x(nextPageButton).shouldBe(visible);
        productList.get(itemNumber - 1).click();
        String parentWindow = getWebDriver().getWindowHandle();
        switchToChildWindow(parentWindow);
        return new ProductPage();
    }

    public CartPage goToCart() {

        clickCartIcon();
        return new CartPage();
    }
}