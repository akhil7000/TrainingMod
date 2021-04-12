package com.training.basetest;

import com.training.utilities.JsonReaderUtility;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class ApiBaseTest {
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    protected Map<String, Object> headerMap;
    protected io.restassured.response.Response response;
    public SoftAssertions softAssertions;

    @BeforeEach
    public void setup()throws NullPointerException{
        softAssertions = new SoftAssertions();
        headerMap = new HashMap();
    }
    @AfterEach
    public void tearDown()throws NullPointerException{
        softAssertions.assertAll();
    }
}
