package com.training.api.tests.cat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.training.api.RequestBody;
import com.training.api.VoteList;
import com.training.utilities.JsonReaderUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatLombokApi {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    Map<String, Object> headerMap;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = map.get("baseUri");
        headerMap = new HashMap();
        headerMap.put(map.get("catAuthenticationHeaderName"), map.get("catAuthenticationHeaderValue"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getIdResponse.csv")
    public void x1(String name, String breedId) {
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("catAuthenticationHeaderName"), map.get("catAuthenticationHeaderValue"));
        String id = "";
        String url = String.format("%s/v1/breeds", map.get("baseUri"));
        Response response = new RestEngine().getResponse2(url, headerMap);

        List<com.training.api.Response> breedName = Arrays.asList(response.as(com.training.api.Response[].class));
        for (int index = 0; index < breedName.size(); index++) {
            if (breedName.get(index).getName().equalsIgnoreCase(name)) {
                id = breedName.get(index).getId();
                logger.info(id);
            }
        }

        Assertions.assertEquals(200, response.getStatusCode(), "Request Unsuccessful");
        Assertions.assertEquals(id, breedId, "Id incorrect");
    }

    @Test
    public void testPostVote() {
        String url = (map.get("baseUri") + "/v1/votes");
        RequestBody requestBody =new RequestBody();
        requestBody.setImage_id("asf2");
        requestBody.setSub_id("test07042021-17");
        requestBody.setValue(1);
        Response response = new RestEngine().postResponse(url, headerMap, new Gson().toJson(requestBody));

        Assertions.assertEquals(200, response.getStatusCode(), "Vote not posted successfully");
        String id = response.as(com.training.api.VoteId.class).getId();

        response = new RestEngine().getResponse2(url,headerMap);
        List<com.training.api.VoteList> voteid = Arrays.asList(response.as(com.training.api.VoteList[].class));
        boolean b=false;
        voteid.get(0).getId();
        for(VoteList a:voteid){
            if(a.getId().equals(id)){
                b=true;
            }
        }
        Assertions.assertEquals(true,b);
    }
}
