package com.training.utilities.tests;

import com.training.base.BaseTest;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class GetJson extends BaseTest {

    @Test
    public void getUrl(){
        System.out.println("URL = "+map.get("url"));
    }
}