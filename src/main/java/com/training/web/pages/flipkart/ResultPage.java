package com.training.web.pages.flipkart;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.training.basepages.FlipkartBasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ResultPage extends FlipkartBasePage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private SelenideElement lowToHigh = $x("//*[text()='Price -- Low to High']");
    private ElementsCollection productResults = $$x("//img[contains(@class,'_2r_T1I')]");
    private ElementsCollection shoesPrice = $$x("//*[@class='_30jeq3']");
    private static SelenideElement nextPageButton = $x("//*[text()='Next']");
    private SelenideElement products = $x("//div[@class='_312yBx SFzpgZ']");

    public ResultPage sortLowToHigh() {
        lowToHigh.shouldBe(visible);
        lowToHigh.click();
        waitForLoader();
        return this;
    }

    public ArrayList<Integer> getPrice() {
        waitForLoader();
        logger.info("Size of list " + (shoesPrice.size()));
        shoesPrice.shouldBe(CollectionCondition.size(40));
        ArrayList<Integer> priceList = new ArrayList<>();
        for (SelenideElement listElement : shoesPrice) {
            priceList.add(Integer.parseInt(listElement.getText().substring(1)));
        }

        logger.info("Size of Pricelist " + (priceList.size()));
        return priceList;
    }

    public ResultPage clickNextPage() {
        nextPageButton.shouldBe(visible);
        nextPageButton.click();
        return this;
    }

    public ArrayList<Integer> sortPriceList(ArrayList<Integer> priceList) {
        waitForLoader();
        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        return sortedPrice;
    }

    public List<SelenideElement> getProductsList() {
        nextPageButton.shouldBe(visible);
        List<SelenideElement> productList = productResults;
        return productList;
    }

    public static ProductPage clickProduct(List<SelenideElement> productList, int itemNumber) {
        nextPageButton.shouldBe(visible);
        productList.get(itemNumber - 1).click();
        String childWindow = null;
        String parentWindow = getWebDriver().getWindowHandle();

        Set<String> windowHandles = getWebDriver().getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        while (windowIterator.hasNext()) {
            String windows = windowIterator.next();
            if (windows != parentWindow) {
                childWindow = windows;
            }
        }
        getWebDriver().switchTo().window(childWindow);
        return new ProductPage();
    }

    public CartPage goToCart() {
        clickCartIcon();
        return new CartPage();
    }
}