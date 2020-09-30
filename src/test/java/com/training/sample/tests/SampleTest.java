package com.training.sample.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.training.sample.pages.SamplePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.pages.Page;
import web.tests.SortingFilter;

/**
 * This is a sample test using Junit5
 */
public class SampleTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void sampleTest(){

        logger.info("Sample test");
        SamplePage samplePage=new SamplePage();
        samplePage.samplePageMethod();
    }


    }
