package com.training.base;

import com.training.utilities.GetJsonValue;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class BaseTest {

    public Map<String, String> map;
    @BeforeEach
    public void testSetup(){
        map = (Map) new GetJsonValue().getValue();
    }
}