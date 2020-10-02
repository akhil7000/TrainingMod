package com.training.utilities.tests;

import com.training.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetJsonTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetUrl(){
        logger.info("URL = "+map.get("url"));
    }
}