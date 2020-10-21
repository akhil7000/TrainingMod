package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.create.RequestBodyCreate;
import com.training.services.ga.create.Response;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import static com.training.utilities.UniqueMailId.getUniqueMailId;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GACreateTest extends BaseTest {
    RequestBodyCreate requestBodyCreate;
    Map<String, Object> headerMap;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    /**
     * testGuestCreation():request body implemented using POJO concept to get the +ve reponse ie 200
     */
    @Test
    public void  testGuestCreation(){
        String firstName="Audrey";
        String lastName="Poole";
        requestBodyCreate=new RequestBodyCreate();
        requestBodyCreate.setBirthdate("19620802");
        String uid=getUniqueMailId();
        requestBodyCreate.setEmail(uid);
        requestBodyCreate.setFirstName(firstName);
        requestBodyCreate.setLastName(lastName);
        requestBodyCreate.setMarketingCountry("USA");
        requestBodyCreate.setPassword("Password1");
        //privacypolicyagreement obj
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.11");
        //securityQuestions obj
        requestBodyCreate.setAnswer("Answer1");
        requestBodyCreate.setQuestion("What was the first concert you attended?");
        requestBodyCreate.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOUq_ATTENDED");
        //termsAndCondition object
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.8");
        requestBodyCreate.setUidType("EMAIL");
        Response responseGACreate  =
                new RestEngine().getResponsePost(map.get("URI")
                        , headerMap
                        ,new Gson().toJson(requestBodyCreate)).as(Response.class);
        logger.info("status"+responseGACreate.getStatus());
        logger.info("error"+responseGACreate.getErrors());
        logger.info("loginstatus"+responseGACreate.getPayload().getLoginStatus());
        Assertions.assertEquals(responseGACreate.getStatus(),"200");
        softAssert.assertThat(responseGACreate.getErrors().size()).isEqualTo(0);
        softAssert.assertThat(responseGACreate.getPayload().getFirstName()).isEqualTo(firstName);
        softAssert.assertThat(responseGACreate.getPayload().getLastName()).isEqualTo(lastName);
        softAssert.assertThat(responseGACreate.getPayload().getLoginStatus()).isEqualTo("AUTHENTICATED");
        softAssert.assertThat(responseGACreate.getPayload().getAccessToken()).isNotEmpty();
        softAssert.assertThat(responseGACreate.getPayload().getOpenIdToken()).isNotEmpty();
        softAssert.assertThat(responseGACreate.getPayload().getRefreshToken()).isNotEmpty();
        softAssert.assertThat(responseGACreate.getPayload().getUid()).isEqualTo(uid);
    }
    /**
     * testWrongMailGuestCreation():passing wrong mail in reqest body using POJO to get response status 422
     */
    @Test
    public void  testWrongMailGuestCreation(){
        String firstName="Audrey";
        String lastName="Poole";
        requestBodyCreate=new RequestBodyCreate();
        requestBodyCreate.setBirthdate("19620802");
        String uid="testShrikant12345555.com";
        requestBodyCreate.setEmail(uid);
        requestBodyCreate.setFirstName(firstName);
        requestBodyCreate.setLastName(lastName);
        requestBodyCreate.setMarketingCountry("USA");
        requestBodyCreate.setPassword("Password1");
        //privacypolicyagreement obj
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.11");
        //securityQuestions obj
        requestBodyCreate.setAnswer("Answer1");
        requestBodyCreate.setQuestion("What was the first concert you attended?");
        requestBodyCreate.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOUq_ATTENDED");
        //termsAndCondition object
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.8");
        requestBodyCreate.setUidType("EMAIL");
        Response responseGACreate  =
                new RestEngine().getResponsePost(map.get("URI")
                        , headerMap
                        ,new Gson().toJson(requestBodyCreate)).as(Response.class);
        logger.info("status->"+responseGACreate.getStatus());
        logger.info("errors->"+responseGACreate.getErrors().get(0).getInternalMessage());
        logger.info("errors->"+responseGACreate.getErrors().get(0).getErrorCode());
        logger.info("error->validatinErrors-->"+responseGACreate.getErrors().get(0).getValidationErrors()
                .get(0).getElement());
        logger.info("error->validatinErrors-->"+responseGACreate.getErrors().get(0).getValidationErrors()
                .get(0).getInvalidValue());
        Assertions.assertEquals(responseGACreate.getStatus(),"422");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getErrorCode()).isEqualTo("GA-0103");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getValidationErrors().get(0)
                .getError()).isEqualTo("The email is invalidly formatted.");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getValidationErrors().get(0)
                .getInvalidValue()).isEqualTo(uid);
    }

}