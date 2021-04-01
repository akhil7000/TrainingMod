package com.training.apitests;

import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private int voteId;
    @Test
    public void getIdResponse() {
        RestAssured.baseURI = "https://api.thecatapi.com/v1/breeds";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("x-api-key", "37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.get();
        logger.info(String.valueOf(response.getBody().prettyPeek()));
        Assertions.assertEquals(response.getStatusCode(),200);
        logger.info(response.body().jsonPath().getString("id"));
        logger.info(response.jsonPath().getString("name"));
    }

    //@ParameterizedTest
    //@CsvFileSource(resources = "/getWikipediaUrl.csv")
    @Test
    public void getWikipediaUrl(){

        //RestAssured.baseURI = String.format("https://api.thecatapi.com/v1/images/search?breed_ids=%s",id);
        RestAssured.baseURI = "https://api.thecatapi.com/v1/images/search?breed_ids=abys";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.get();
        //logger.info(String.valueOf(response.getBody().asPrettyString()));
        Assertions.assertEquals(response.getStatusCode(),200);
        //System.out.println(((response.jsonPath().getJsonObject("breeds"))).getClass().getSimpleName());
        List<JSONObject> breeds = response.jsonPath().getJsonObject("breeds");
        System.out.println(breeds.get(0));

    }

    @Test
    public  void postVote(){
        JSONObject vote = new JSONObject();
        vote.put("image_id","asf2");
        vote.put("sub_id","test31014563");
        vote.put("value",1);

        RestAssured.baseURI = "https://api.thecatapi.com/v1/votes";
        Response response = given()
                .contentType("application/json")
                .header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0")
                .body(vote.toJSONString())
                .when()
                .post();

        Assertions.assertEquals(response.getStatusCode(),200);

        voteId=response.jsonPath().getInt("id");

    }

    @Test
    public void getVoteList(){
        RestAssured.baseURI = "https://api.thecatapi.com/v1/votes";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("x-api-key","37b0987e-eb13-4193-82b1-56f33b574ac0");
        Response response = httpRequest.get();

        Assertions.assertEquals(response.getStatusCode(),200);

        List<Object> list = response.jsonPath().getList("id");
        logger.info(String.valueOf(voteId));
        Assertions.assertTrue(list.contains(voteId));
    }
}
