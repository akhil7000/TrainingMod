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

public class CatApiTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    RequestSpecification httpRequest;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = map.get("baseUri");
        httpRequest = RestAssured.given();
        httpRequest.header(map.get("catAuthenticationHeaderName"), map.get("catAuthenticationHeaderValue"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getIdResponse.csv")
    public void testGetIdResponse(String name, String breedId) {

        Response response = httpRequest.get("/v1/breeds");

        Assertions.assertEquals(response.getStatusCode(), 200);

        List<String> breedName = response.jsonPath().getList("name");
        int index = breedName.indexOf(name);
        String id = response.jsonPath().getString(String.format("id[%s]",index));
        logger.info(id);
        Assertions.assertEquals(breedId, id,"Id incorrect");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void testGetWikipediaUrl(String id, String url) {

        String path = String.format("/v1/images/search?breed_ids=%s", id);
        Response response = httpRequest.when().get(path);
        Assertions.assertEquals( 200,response.getStatusCode(),"Request Unsuccessful");

        String wikipediaUrl = response.jsonPath().getString("breeds[0].wikipedia_url");
        Assertions.assertTrue(wikipediaUrl.contains(url), "Url is not correct");
    }

    @Test
    public void testPostVote() {

        JSONObject vote = new JSONObject();
        vote.put("image_id", "asf2");
        vote.put("sub_id", "test05042021-9");
        vote.put("value", 1);

        Response response = httpRequest
                .contentType("application/json")
                .body(vote.toJSONString())
                .when()
                .post("/v1/votes");

        Assertions.assertEquals(200,response.getStatusCode(), "Vote not posted successfully");

        int id = response.jsonPath().getInt("id");
        response = httpRequest.get("/v1/votes");
        List<Integer> list = response.jsonPath().getList("id");

        Assertions.assertTrue(list.contains(id),"Vote was not posted successfully");
    }
}
