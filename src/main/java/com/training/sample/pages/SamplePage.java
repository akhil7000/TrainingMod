package com.training.sample.pages;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;

/**
 * This is a sample Page class
 */
public class SamplePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public  WebElement popUpCross = $x("//div[@class='mCRfo9']/div/div/button");
    public static WebElement setShoes = $x("//form/div/div/input");
    public static WebElement searchShoes = $x("//button[@class='vh79eN']");
    public static WebElement secondpage = $x("//a[@class='_2Xp0TH'][contains(text(),'2')]");
    public SamplePage popUpCancel(){
      if(popUpCross.isEnabled()){
          popUpCross.click();
      }
        return this;
    }
    public SamplePage setShoes(String product){
        setShoes.sendKeys(product);
        return this;
    }
    public SamplePage searchShoes(){
        searchShoes.click();
        return this;
    }

}
