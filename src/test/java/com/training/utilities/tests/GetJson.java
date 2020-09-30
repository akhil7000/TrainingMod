package com.training.utilities.tests;

import com.training.base.Base;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class GetJson extends Base {

    @Test
    public void getUrl(){
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println((String)entry.getValue());
        }
    }
}