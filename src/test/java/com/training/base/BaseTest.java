package com.training.base;

import com.training.utilities.GetJsonValue;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class BaseTest {

    public Map<String, String> map;
    public SoftAssertions softAssert;
    /**
     * Getting json data and storing it in map variable
     */
    @BeforeEach
    public void testSetup(){
        softAssert = new SoftAssertions();
        map = (Map) new GetJsonValue().getValue();
    }
    @AfterEach
    public void tearDown(){
        softAssert.assertAll();
    }
}