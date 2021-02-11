package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoesResultPage {
    WebDriver driver;

    public ShoesResultPage(WebDriver driver) {
        this.driver = driver;
    }

    By lowToHigh = By.xpath("//div[contains(text(),'Price -- Low to High')]");
    By shoesPrice = By.xpath("//div[@class='_30jeq3']");
    By loaderIcon = By.xpath("//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']");
    By nextPageButton = By.xpath("//*[contains(text(),'Next')]");

    public WebElement low() {
        return driver.findElement(lowToHigh);
    }

    public String loader() {
        return "//div[@class='_2YsvKq _3bgaUQ']/*[name()='svg']";
    }

    public List<WebElement> shoePrice() {
        List<WebElement> list = driver.findElements(shoesPrice);
        return list;
    }

    public WebElement next() {
        return driver.findElement(nextPageButton);
    }

    public ArrayList<Integer> getPrice(List<WebElement> list) throws InterruptedException {
        ArrayList<Integer> priceList=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String pricetemp = list.get(i).getText();
            priceList.add(Integer.parseInt(pricetemp.substring(1)));
        }
        return priceList;
    }
}
