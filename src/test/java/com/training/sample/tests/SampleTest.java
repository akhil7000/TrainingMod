package com.training.sample.tests;

import com.google.gson.Gson;
import com.training.sample.pages.SamplePage;
import jdk.nashorn.internal.parser.JSONParser;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SampleTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void sampleTest(){

        logger.info("Sample test");
        SamplePage samplePage=new SamplePage();
        samplePage.samplePageMethod();
    }
}
