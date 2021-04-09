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

import java.util.*;

public class CatApiTests {
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
        io.restassured.response.Response response = new RestEngine().getResponse("/v1/breeds", headerMap);
        Assertions.assertEquals(200, response.getStatusCode(), "Request Unsuccessful");

        List<com.training.pojos.cat.breeds.Response> responseList = Arrays.asList(response.as(com.training.pojos.cat.breeds.Response[].class));
        for (int index = 0; index < responseList.size(); index++) {
            if (responseList.get(index).getName().equalsIgnoreCase(name)) {
                id = responseList.get(index).getId();
                break;
            }
        }

        Assertions.assertEquals(id, breedId, "Id incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void testGetWikipediaUrl(String id, String url) {
        io.restassured.response.Response response = new RestEngine()
                .getResponse(String.format("/v1/images/search?breed_ids=%s", id), headerMap);

        Assertions.assertEquals(200, response.getStatusCode(), "Request Unsuccessful");

        List<com.training.pojos.cat.search.Response> responseList =
           Arrays.asList(response.as(com.training.pojos.cat.search.Response[].class));


        String wikipediaUrl = responseList.get(0).getBreeds().get(0).getWikipedia_url();

        Assertions.assertEquals(url, wikipediaUrl, "Wikipedia Url does not match");
    }

    @Test
    public void testPostVote() {

        Request request = new Request();
        request.setImage_id("asf2");
        request.setSub_id("test08042021-5");
        request.setValue(1);

        io.restassured.response.Response response = new RestEngine().getPostResponse("/v1/votes", headerMap,
                new Gson().toJson(request));

        Assertions.assertEquals(200, response.getStatusCode(), "Vote not posted successfully");
        String id = response.as(com.training.pojos.cat.vote.Response.class).getId();

        response = new RestEngine().getResponse("/v1/votes", headerMap);
        List<Response> responseList = Arrays.asList(response.as(com.training.pojos.cat.vote.Response[].class));

        boolean idPresent = false;
        for (Response a : responseList) {
            if (a.getId().equals(id)) {
                idPresent = true;
                break;
            }
        }
        Assertions.assertTrue(idPresent, "Voting information not retrieved");
    }
}