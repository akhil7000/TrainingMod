package com.training.sample.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.training.sample.pages.SamplePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a sample test using Junit5
 */
public class SampleTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
SamplePage sample=new SamplePage();
SortingFilter sortfilter=new SortingFilter();
    @BeforeEach
    public void init(){
        Configuration.baseUrl="https://www.flipkart.com";
        Selenide.open("/");
    }

    @Test
    public void sampleTest() throws Exception {
            Assertions.assertTrue(getDetails());
    }
      public Boolean test1(String product,String filter) throws Exception {
          product=product.trim();
          logger.info(product);
           //to handle popup
          sample.popUpCancel();
          //to enter product i.e shoes in textfield
          sample.setShoes(product);
          //to enter search button
          sample.searchShoes();
          Thread.sleep(5000);
          //to select low to high filter option
          sortfilter.sortShoes(filter);//price low to high
          Thread.sleep(5000);
          //to do the pagination of page1
          sortfilter.counting();//counting prices of page1

         // sortfilter.counting();//counting prices of page2
      return true;
    }

    public Boolean getDetails() throws Exception {
        String product ="shoes";
        String filter="Price -- Low to High";
        return test1(product,filter);
    }

    }
