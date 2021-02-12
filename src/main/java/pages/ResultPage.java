package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultPage {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    WebDriver driver;
    WebDriverWait wait;
    ArrayList<Integer> priceList = new ArrayList<>();

    By lowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
    By shoesPrice = By.xpath("//div[@class='_30jeq3']");
    By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    By nextPageButton = By.xpath("//*[contains(text(),'Next')]");

    public ResultPage(WebDriver driver) {

        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;
    }


    public ResultPage sortLowToHigh() {

        wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));
        driver.findElement(lowToHigh).click();
        return this;
    }

    public List<WebElement> getShoesPrice() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']")));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoesPrice));

        List<WebElement> list = driver.findElements(shoesPrice);
        return list;
    }

    public ArrayList<Integer> getPriceInteger(List<WebElement> list) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoesPrice));
        ArrayList<Integer> priceList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            priceList.add(Integer.parseInt(list.get(i).getText().substring(1)));
        }

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

}