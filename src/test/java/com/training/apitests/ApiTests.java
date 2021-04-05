package com.training.apitests;

import com.training.utilities.JsonReaderUtility;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Map<String, String> map = new JsonReaderUtility().getMap();

    @ParameterizedTest
    @CsvFileSource(resources = "/getIdResponse.csv")
    public void testGetIdResponse(String name, String id) {

        RestAssured.baseURI = map.get("baseUri");
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header(map.get("headerName"), map.get("headerValue"));
        Response response = httpRequest.get("/v1/breeds");

        Assertions.assertEquals(response.getStatusCode(), 200);

        List<String> breedName = response.jsonPath().getList("name");
        List<String> breedId = response.jsonPath().getList("id");
        logger.info(breedId.get(breedName.indexOf(name)));

        Assertions.assertEquals(breedId.get(breedName.indexOf(name)), id);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void testGetWikipediaUrl(String id, String url) {

        RestAssured.baseURI = map.get("baseUri");
        String searchUrl = String.format("https://api.thecatapi.com/v1/images/search?breed_ids=%s", id);
        //RestAssured.baseURI = "https://api.thecatapi.com/v1/images/search?breed_ids=abys";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header(map.get("headerName"), map.get("headerValue"));
        Response response = httpRequest.when().get("/v1/breeds");
        //Response response = httpRequest.when().get("/v1/images/search?breed_ids=abys");

        Assertions.assertEquals(response.getStatusCode(), 200);
        List<String> breeds = response.jsonPath().getList("id");
        List<String> wikipediaUrl = response.jsonPath().getList("wikipedia_url");

        logger.info(String.valueOf(breeds.indexOf(id)));
        logger.info(wikipediaUrl.get(breeds.indexOf(id)));

        Assertions.assertEquals(wikipediaUrl.get(breeds.indexOf(id)), url, "Wikipedia Url not found");
        System.out.println(searchUrl);

    }

    @Test
    public void testPostVote() throws IOException {

        JSONObject vote = new JSONObject();
        vote.put("image_id", "asf2");
        vote.put("sub_id", "test05042021-7");
        vote.put("value", 1);

        RestAssured.baseURI = map.get("baseUri");
        Response response = given()
                .contentType("application/json")
                .header(map.get("headerName"), map.get("headerValue"))
                .body(vote.toJSONString())
                .when()
                .post("/v1/votes");

        Assertions.assertEquals(response.getStatusCode(), 200, "Vote not posted successfully");

        int id = response.jsonPath().getInt("id");

        RestAssured.baseURI = map.get("baseUri");
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header(map.get("headerName"), map.get("headerValue"));
        response = httpRequest.get("/v1/votes");

        List<Integer> list = response.jsonPath().getList("id");

        Assertions.assertTrue(list.contains(id));

    }

}
