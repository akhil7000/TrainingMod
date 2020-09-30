package web.pages.flipkart;

import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    public static WebElement secondpage = $x("//a[@class='_2Xp0TH'][contains(text(),'2')]");

    public SearchPage selectSecondPage() {
        secondpage.click();
        return this;
    }
}
