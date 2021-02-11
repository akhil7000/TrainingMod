package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultPage {
    WebDriver driver;

    public ResultPage(WebDriver driver) {

        this.driver = driver;
    }

    By lowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
    By shoesPrice = By.xpath("//div[@class='_30jeq3']");
    By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    By nextPageButton = By.xpath("//*[contains(text(),'Next')]");

    public WebElement low() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));
        return driver.findElement(lowToHigh);
    }

    public List<WebElement> shoePrice() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(shoesPrice));

        List<WebElement> list = driver.findElements(shoesPrice);
        return list;
    }

    public WebElement next() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        return driver.findElement(nextPageButton);
    }

    public ArrayList<Integer> getPrice(List<WebElement> list) {

        ArrayList<Integer> priceList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String pricetemp = list.get(i).getText();
            priceList.add(Integer.parseInt(pricetemp.substring(1)));
        }

        return priceList;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> priceList) {

        ArrayList<Integer> sortedPrice = (ArrayList<Integer>) priceList.clone();
        Collections.sort(sortedPrice);
        return sortedPrice;
    }
}