package com.training.api.tests.cat;

import com.google.gson.Gson;
import com.training.pojos.cat.vote.Request;
import com.training.pojos.cat.vote.Response;
import com.training.utilities.JsonReaderUtility;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CatApiTests {
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    private Map<String, Object> headerMap;
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private io.restassured.response.Response response;

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
        response = new RestEngine().getResponse("/v1/breeds", headerMap);
        Assertions.assertEquals(200, response.getStatusCode(), REQUEST_UNSUCCESSFUL);


        for (com.training.pojos.cat.breeds.Response responseElement :
                Arrays.asList(response.as(com.training.pojos.cat.breeds.Response[].class))) {
            if (responseElement.getName().equalsIgnoreCase(name)) {
                id = responseElement.getId();
                break;
            }
        }

        Assertions.assertEquals(id, breedId, "Id incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void testGetWikipediaUrl(String id, String url) {
        response = new RestEngine()
                .getResponse(String.format("/v1/images/search?breed_ids=%s", id), headerMap);

            Assertions.assertEquals(200, response.getStatusCode(), REQUEST_UNSUCCESSFUL);

        Assertions.assertEquals(url,
                Arrays.asList(response.as(com.training.pojos.cat.search.Response[].class))
                        .get(0).getBreeds().get(0).getWikipedia_url(),
                "Wikipedia Url does not match");
    }

    @Test
    public void testPostVote() {
        boolean idPresent = false;
        String url = "/v1/votes";
        String id="";
        Request request = new Request();
        request.setImage_id("asf2");
        request.setSub_id("test09042021-5");
        request.setValue(1);


        response = new RestEngine().getResponse(url, headerMap,
                new Gson().toJson(request));
        Assertions.assertEquals(200, response.statusCode(), REQUEST_UNSUCCESSFUL);
        id = response.as(com.training.pojos.cat.vote.Response.class).getId();

        response = new RestEngine().getResponse(url, headerMap);
        Assertions.assertEquals(200,response.statusCode(),REQUEST_UNSUCCESSFUL);

        for (Response responseElement :
                Arrays.asList(response.as(com.training.pojos.cat.vote.Response[].class))) {
            if (responseElement.getId().equals
                    (id)) {
                idPresent = true;
                break;
            }
        }
        Assertions.assertTrue(idPresent, "Voting information not retrieved");
    }
}