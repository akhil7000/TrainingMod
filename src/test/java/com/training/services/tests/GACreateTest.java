package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.*;
import com.training.services.ga.create.RequestBodyCreate;
import com.training.services.ga.create.SecurityQuestions;
import com.training.utilities.GetUniqueMailId;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GACreateTest extends BaseTest {
    RequestBodyCreate requestBodyCreate;
    Map<String, Object> headerMap;
    GetUniqueMailId mail=new GetUniqueMailId();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    /**
     * testGuestCreation():
     */
    @Test
    public void  testGuestCreation(){
        requestBodyCreate=new RequestBodyCreate();
        requestBodyCreate.setBirthdate("19620802");
        String uniqueMailId=mail.getUniqueMailId();
       // requestBodyCreate.setEmail("testShrikant"+uniqueId+"@api.com");
        System.out.print(uniqueMailId+"******");
        requestBodyCreate.setEmail(uniqueMailId);
        requestBodyCreate.setFirstName("Audrey");
        requestBodyCreate.setLastName("Poole");
        requestBodyCreate.setMarketingCountry("USA");
        requestBodyCreate.setPassword("Password1");
        //privacypolicyagreement obj
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.11");

//        SecurityQuestions questions=new SecurityQuestions();
//        questions.setAnswer("Answer1");
//        questions.setQuestion("What was the first concert you attended?");
//        questions.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED");
//        List<SecurityQuestions> securityQuestions = new ArrayList<SecurityQuestions>();
//        securityQuestions.add(questions);
//        requestBodyCreate.setSecurityQuestions(securityQuestions);

        requestBodyCreate.setAnswer("Answer1");
        requestBodyCreate.setQuestion("What was the first concert you attended?");
        requestBodyCreate.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED");


//        List<SecurityQuestions> securityQuestions = new ArrayList<SecurityQuestions>();
//        securityQuestions.add(questions);
//        requestBodyCreate.setSecurityQuestions(securityQuestions);


       //terms and condition object
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT");
        requestBodyCreate.setVersion("1.8");
        requestBodyCreate.setUidType("EMAIL");
        Response responseCreation  =
                new RestEngine().getResponsePost(map.get("URI")
                        , headerMap
                        ,new Gson().toJson(requestBodyCreate)).as(Response.class);
        logger.info("status"+responseCreation.getStatus());
        logger.info("Account id"+responseCreation.getPayload().getAccountId());
        logger.info("error"+responseCreation.getErrors());
        logger.info("loginstatus"+responseCreation.getPayload().getLoginStatus());
        Assertions.assertEquals(responseCreation.getStatus(),"200");
    }
}