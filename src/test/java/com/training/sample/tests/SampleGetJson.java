package com.training.sample.tests;

import com.training.sample.pages.SamplePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SampleGetJson {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    String getURl;
    @BeforeEach
    public void sampleTest(){
        SamplePage samplePage=new SamplePage();
       getURl = samplePage.getUrl();
    }
    @Test
    public void getUrl(){
        logger.info("URL = "+getURl);
    }
}
