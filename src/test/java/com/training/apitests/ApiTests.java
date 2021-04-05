package com.training.apitests;

import com.training.utilities.ApiUtilities;
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

import static io.restassured.RestAssured.given;

public class ApiTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ApiUtilities apiUtilities;

    @ParameterizedTest
    @CsvFileSource(resources = "/getIdResponse.csv")
    public void getIdResponse(String name,String id) {
        RestAssured.baseURI = "https://api.thecatapi.com/v1/breeds";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("x-api-key", "37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.get();

        Assertions.assertEquals(response.getStatusCode(),200);

        List<String> breedName = response.jsonPath().getList("name");
        List<String> breedId = response.jsonPath().getList("id");
        logger.info(breedId.get(breedName.indexOf(name)));

        Assertions.assertEquals(breedId.get(breedName.indexOf(name)),id);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/getWikipediaUrl.csv")
    public void getWikipediaUrl(String id, String url){
        RestAssured.baseURI = "https://api.thecatapi.com/v1/breeds";
        String searchUrl = String.format("https://api.thecatapi.com/v1/images/search?breed_ids=%s",id);
        //RestAssured.baseURI = "https://api.thecatapi.com/v1/images/search?breed_ids=abys";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.when().get();
        //Response response = httpRequest.when().get("https://api.thecatapi.com/v1/images/search?breed_ids=abys");

        Assertions.assertEquals(response.getStatusCode(),200);
        List<String> breeds = response.jsonPath().getList("id");
        List<String> wikipediaUrl = response.jsonPath().getList("wikipedia_url");

        logger.info(String.valueOf(breeds.indexOf(id)));
        logger.info(wikipediaUrl.get(breeds.indexOf(id)));

        Assertions.assertEquals(wikipediaUrl.get(breeds.indexOf(id)),url,"Wikipedia Url not found");
        System.out.println(searchUrl);

    }

    @Test
    public  void postVote() throws IOException {

        JSONObject vote = new JSONObject();
        vote.put("image_id","asf2");
        vote.put("sub_id","test05042021-4");
        vote.put("value",1);

        RestAssured.baseURI = "https://api.thecatapi.com/v1/votes";
        Response response = given()
                .contentType("application/json")
                .header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0")
                .body(vote.toJSONString())
                .when()
                .post();

        Assertions.assertEquals(response.getStatusCode(),200,"Vote not posted successfully");
        apiUtilities.writeCsv(response.jsonPath().getInt("id"));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/voteData.csv")
    public void getVoteList(String id){

        RestAssured.baseURI = "https://api.thecatapi.com/v1/votes";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.get();

        Assertions.assertEquals(response.getStatusCode(),200);

        List<Integer> list = response.jsonPath().getList("id");

        Assertions.assertTrue(list.contains(Integer.parseInt(id)),"Vote not found");
    }
}
