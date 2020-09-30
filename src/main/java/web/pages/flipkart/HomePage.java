package web.pages.flipkart;

import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public WebElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static WebElement setShoes = $x("//form/div/div/input");
    public static WebElement searchShoes = $x("//button[@class='vh79eN']");

    public HomePage popUpCancel(){
        if(popUpCross.isEnabled()){
            popUpCross.click();
        }
        return this;
    }
    public HomePage setShoes(String product){
        setShoes.sendKeys(product);
        return this;
    }
    public HomePage searchShoes(){
        searchShoes.click();
        return this;
    }


}
