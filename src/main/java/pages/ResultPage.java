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

    private WebDriver driver;
    private WebDriverWait wait;

    private By lowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
    private By shoesPrice = By.xpath("//div[@class='_30jeq3']");
    private By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    private By nextPageButton = By.xpath("//*[contains(text(),'Next')]");

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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoesPrice));

        List<WebElement> list = driver.findElements(shoesPrice);
        logger.info("Size of list " + String.valueOf(list.size()));

        ArrayList<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            priceList.add(Integer.parseInt(list.get(i).getText().substring(1)));
        }
        logger.info("Size of Pricelist " + String.valueOf(priceList.size()));
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