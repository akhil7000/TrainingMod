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

    private By lowToHigh = By.xpath("//*[text()='Price -- Low to High']");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By productResults = By.xpath("//img[contains(@class,'_2r_T1I')]");
    private By shoesPrice = By.className("_30jeq3");
    private By nextPageButton = By.xpath("//*[text()='Next']");
    private By cart = By.xpath("//*[text()='Cart']");
    private By products = By.xpath("//div[@class='_312yBx SFzpgZ']");

    public ResultPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }

    public ResultPage sortLowToHigh() {
        wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));
        driver.findElement(lowToHigh).click();
        wait.until(ExpectedConditions.elementToBeClickable(shoesPrice));
        return this;
    }

    public ArrayList<Integer> getPrice() {
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
        wait.until(ExpectedConditions.elementToBeClickable(products));
        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        return sortedPrice;
    }

    public List<WebElement> getProductsList() {
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        wait.until(ExpectedConditions.elementToBeClickable(productResults));
        List<WebElement> productList = driver.findElements(productResults);
        return productList;
    }

    public ProductPage clickProduct(List<WebElement> productList, int itemNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        wait.until(ExpectedConditions.elementToBeClickable(productResults));
        String childWindow = null;

        String parentWindow = driver.getWindowHandle();
        productList.get((itemNumber) - 1).click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();
        while (windowIterator.hasNext()) {
            String windows = windowIterator.next();
            if (windows != parentWindow) {
                childWindow = windows;
            }
        }
        driver.switchTo().window(childWindow);
        return new ProductPage(driver);
    }

    public CartPage goToCart(WebDriver driver) {
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
}