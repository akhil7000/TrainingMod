package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.*;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    @Test
    public void  testGuestCreation(){
        requestBodyCreate=new RequestBodyCreate();
        requestBodyCreate.setBirthdate("19620802");
        requestBodyCreate.setEmail("testShrikant18809@api.com");
        requestBodyCreate.setFirstName("Audrey");
        requestBodyCreate.setLastName("Poole");
        requestBodyCreate.setMarketingCountry("USA");
        requestBodyCreate.setPassword("Password1");
        ///curly braces only need to create class and pass the object to response object
        PrivacyPolicyAgreement privacyPolicyAgreement=new PrivacyPolicyAgreement();
        privacyPolicyAgreement.setAcceptDateTime("20190524T090712GMT");
        privacyPolicyAgreement.setVersion("1.11");
        requestBodyCreate.setPrivacyPolicyAgreement(privacyPolicyAgreement);
        //securityQuestions as list
        SecurityQuestions questions=new SecurityQuestions();
        questions.setAnswer("Answer1");
        questions.setQuestion("What was the first concert you attended?");
        questions.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED");
        List<SecurityQuestions> securityQuestions = new ArrayList<SecurityQuestions>();
        securityQuestions.add(questions);
        requestBodyCreate.setSecurityQuestions(securityQuestions);// array[{}]
        ///curly braces only need to create class and pass the object to response object
        TermsAndConditionsAgreement termsAndConditionsAgreement=new TermsAndConditionsAgreement();
        termsAndConditionsAgreement.setAcceptDateTime("20190524T090712GMT");
        termsAndConditionsAgreement.setVersion("1.8");
        requestBodyCreate.setTermsAndConditionsAgreement(termsAndConditionsAgreement);//curly braces
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
