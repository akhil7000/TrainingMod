package com.training.utilities.tests;

import com.training.base.BaseTest;
import org.junit.jupiter.api.Test;

public class GetJsonTest extends BaseTest {

    @Test
    public void testGetUrl(){
        System.out.println("URL = "+map.get("url"));
    }
}