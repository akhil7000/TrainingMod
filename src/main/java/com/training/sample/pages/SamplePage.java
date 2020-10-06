package com.training.sample.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a sample Page class
 */
public class SamplePage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void samplePageMethod(){
        logger.info("This is a method in Sample Page");
    }
}