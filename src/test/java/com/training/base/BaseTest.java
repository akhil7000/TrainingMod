package com.training.base;

import com.codeborne.selenide.Selenide;
import com.training.utilities.GetJsonValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class BaseTest {

    public Map<String, String> map;

    /**
     * Getting json data and storing it in map variable
     */
    @BeforeEach
    public void testSetup(){
        map = (Map) new GetJsonValue().getValue();
    }
    @AfterEach
    public void tearDown(){

    }
}