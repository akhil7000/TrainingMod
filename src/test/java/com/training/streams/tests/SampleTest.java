package com.training.streams.tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a sample test using Junit5
 */
public class SampleTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void sampleTest(){
        logger.info("Sample test");
    }
}
