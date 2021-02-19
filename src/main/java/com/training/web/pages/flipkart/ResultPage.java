package com.training.web.pages.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class ResultPage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;
    private WebDriverWait wait;
    List<WebElement> productList;

    private By lowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By productResults = By.xpath("//img[contains(@class,'_2r_T1I')]");
    private By shoesPrice = By.className("_30jeq3");
    private By nextPageButton = By.xpath("//*[text()='Next']");
    private By cart = By.xpath("//*[text()='Cart']");

    public ResultPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ResultPage sortLowToHigh() {
        wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));
        driver.findElement(lowToHigh).click();
        return this;
    }

    public ArrayList<Integer> getPriceInteger() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoesPrice));

        List<WebElement> list = driver.findElements(shoesPrice);
        logger.info("Size of list " + (list.size()));

        ArrayList<Integer> priceList = new ArrayList<>();
        for (WebElement listElement : list) {
            priceList.add(Integer.parseInt(listElement.getText().substring(1)));
        }

        logger.info("Size of Pricelist " + (priceList.size()));
        return priceList;
    }

    public ResultPage clickNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        driver.findElement(nextPageButton).click();
        return this;
    }

    public ArrayList<Integer> sortPriceList(ArrayList<Integer> priceList) {
        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        return sortedPrice;
    }

    public ProductPage clickProduct(int itemNumber) {

        String parentWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        itemNumber = itemNumber - 1;
        productList.get((itemNumber)).click();

        Set<String> s = driver.getWindowHandles();
        String childWindow = null;
        Iterator<String> I1 = s.iterator();
        while (I1.hasNext()) {
            if (I1.next() != parentWindow) ;
            childWindow = I1.next();
        }
        driver.switchTo().window(childWindow);
        return new ProductPage(driver);
    }

    public ResultPage setProductsList() {
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        productList = driver.findElements(shoesPrice);
        return this;
    }

    public CartPage goToCart() {
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
}