package com.training.utilities.tests;

import com.training.utilities.GetJsonValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetJson {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    String getValue;

    @BeforeEach
    public void sampleTest(){
        GetJsonValue samplePage=new GetJsonValue();
        getValue = samplePage.getValue("product");
    }
    @Test
    public void getUrl(){
        logger.info("Value = "+getValue);
    }
}
