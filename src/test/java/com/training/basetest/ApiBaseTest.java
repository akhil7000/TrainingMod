package com.training.basetest;

import com.training.utilities.JsonReaderUtility;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.util.HashMap;
import java.util.Map;

public class ApiBaseTest {
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    protected Map<String, Object> headerMap;
    protected io.restassured.response.Response response;
    SoftAssertions softAssertions;

    @BeforeEach
    public void setup(){
        RestAssured.baseURI = map.get("gaBaseUrl");
        headerMap = new HashMap();
        headerMap.put(map.get("gaValidationAppKeyHeaderName"),map.get("gaValidationAppKeyHeaderValue"));
        headerMap.put(map.get("gaValidationContentTypeHeaderName") ,map.get("gaValidationContentTypeHeaderValue"));
        softAssertions = new SoftAssertions();
    }
    @AfterEach
    public void tearDown(){
        softAssertions.assertAll();
    }
}
