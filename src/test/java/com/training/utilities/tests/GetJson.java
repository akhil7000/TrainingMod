package com.training.utilities.tests;

import com.training.utilities.SamplePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetJson {

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
