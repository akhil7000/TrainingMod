package com.training.api.tests.cat;

import com.google.gson.Gson;
import com.training.pojos.cat.vote.RequestBody;
import com.training.pojos.cat.vote.Response;
import com.training.utilities.JsonReaderUtility;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
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

public class CatApiTests {
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
    public void testGetBreedId(String name, String breedId) {
        String id = "";
        String url = "/v1/breeds";
        io.restassured.response.Response response = new RestEngine().getResponse(url,headerMap);
        Assertions.assertEquals(200, response.getStatusCode(), "Request Unsuccessful");

        List<com.training.pojos.cat.breeds.Response> breedName = Arrays.asList(response.as(com.training.pojos.cat.breeds.Response[].class));
        for (int index = 0; index < breedName.size(); index++) {
            if (breedName.get(index).getName().equalsIgnoreCase(name)) {
                id = breedName.get(index).getId();
                logger.info(id);
            }
        }

        Assertions.assertEquals(id, breedId, "Id incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void testGetWikipediaUrl(String id, String url) {
        String path = String.format("/v1/images/search?breed_ids=%s", id);
        io.restassured.response.Response response = new RestEngine().getResponse(path,headerMap);
        Assertions.assertEquals( 200,response.getStatusCode(),"Request Unsuccessful");

        List<com.training.pojos.cat.search.Response> breed =
                Arrays.asList(response.as(com.training.pojos.cat.search.Response[].class));

        String wikipediaUrl= breed.get(0).getBreeds()[0].getWikipedia_url();
        logger.info(wikipediaUrl);
        Assertions.assertEquals(url,wikipediaUrl,"Response Not Correct");
    }

    @Test
    public void testPostVote() {
        String url = "/v1/votes";
        RequestBody requestBody = new RequestBody();
        requestBody.setImage_id("asf2");
        requestBody.setSub_id("test08042021-3");
        requestBody.setValue(1);
        io.restassured.response.Response response = new RestEngine().setResponse(url, headerMap, new Gson().toJson(requestBody));

        Assertions.assertEquals(200, response.getStatusCode(), "Vote not posted successfully");
        String id = response.as(com.training.pojos.cat.vote.Response.class).getId();
        logger.info(id);

        response = new RestEngine().getResponse(url,headerMap);
        List<Response> voteId = Arrays.asList(response.as(com.training.pojos.cat.vote.Response[].class));

        boolean idPresent=false;
        voteId.get(0).getId();
        for(Response a:voteId){
            if(a.getId().equals(id)){
                idPresent=true;
            }
        }
        Assertions.assertEquals(true,idPresent);
    }
}