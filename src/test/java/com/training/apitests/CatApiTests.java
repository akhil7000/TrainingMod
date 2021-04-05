package com.training.apitests;

import com.training.utilities.JsonReaderUtility;
import org.junit.jupiter.api.BeforeEach;
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
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CatApiTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    RequestSpecification httpRequest;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = map.get("baseUri");
        httpRequest = RestAssured.given();
        httpRequest.header(map.get("headerName"), map.get("headerValue"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getIdResponse.csv")
    public void testGetIdResponse(String name, String id) {

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
        String path = String.format("/v1/images/search?breed_ids=%s", id);
        Response response = httpRequest.when().get(path);
        Assertions.assertEquals(response.getStatusCode(), 200);

        String wikipediaUrl = response.jsonPath().getString("breeds[0].wikipedia_url");
        Assertions.assertTrue(wikipediaUrl.contains(url), "Url is not correct");
    }

    @Test
    public void testPostVote() {

        JSONObject vote = new JSONObject();
        vote.put("image_id", "asf2");
        vote.put("sub_id", "test05042021-9");
        vote.put("value", 1);

        Response response = given()
                .contentType("application/json")
                .header(map.get("headerName"), map.get("headerValue"))
                .body(vote.toJSONString())
                .when()
                .post("/v1/votes");

        Assertions.assertEquals(response.getStatusCode(), 200, "Vote not posted successfully");

        int id = response.jsonPath().getInt("id");
        response = httpRequest.get("/v1/votes");
        List<Integer> list = response.jsonPath().getList("id");

        Assertions.assertTrue(list.contains(id));
    }
}
