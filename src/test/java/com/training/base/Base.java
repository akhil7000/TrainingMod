package com.training.base;

import com.training.utilities.GetJsonValue;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

public class Base {

   public Map<?, ?> map;

    @BeforeEach
    public void sampleTest(){
        GetJsonValue samplePage=new GetJsonValue();
        map = (Map<?, ?>) samplePage.getValue();
    }
}