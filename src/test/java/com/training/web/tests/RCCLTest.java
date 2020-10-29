package com.training.web.tests;

import com.codeborne.selenide.Selenide;
import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.create.RequestBodyCreate;
import com.training.utilities.RestEngine;
import com.training.web.pages.rccl.HomePage;
import com.training.web.pages.rccl.LoginPage;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.training.services.ga.create.Response;
import static com.training.utilities.UniqueMailId.getUniqueMailId;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RCCLTest extends BaseTest {
    Map<String, Object> headerMap;
    RequestBodyCreate requestBodyCreate;
    String uid=getUniqueMailId();
    String firstName="Audrey";
    String lastName="Poole";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        requestBodyCreate=new RequestBodyCreate();
        requestBodyCreate.setBirthdate("19620802");
        requestBodyCreate.setEmail(uid);
        requestBodyCreate.setFirstName(firstName);
        requestBodyCreate.setLastName(lastName);
        requestBodyCreate.setMarketingCountry("USA");
        requestBodyCreate.setPassword("Password1");
        //privacypolicyagreement obj
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT",1);
        requestBodyCreate.setVersion("1.11",1);
        //securityQuestions obj
        requestBodyCreate.setAnswer("Answer1");
        requestBodyCreate.setQuestion("What was the first concert you attended?");
        requestBodyCreate.setQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED");
        //termsAndCondition object
        requestBodyCreate.setAcceptDateTime("20190524T090712GMT", 2);
        requestBodyCreate.setVersion("1.8", 2);
        requestBodyCreate.setUidType("EMAIL");
    }

    /**
     *
     * @param: get Body in pojo format
     * @return :Response
     */
    public Response getResponse(RequestBodyCreate requestBodyCreate ){
        return  new RestEngine().getResponsePost(map.get("URI")
                , headerMap
                ,new Gson().toJson(requestBodyCreate)).as(Response.class);
    }

    /**
     *testUserUIValidate():Performing validation of elements using combination of web and Services
     */
    @Test
    public void  testUserUIValidate() throws InterruptedException {
        Response responseGACreate= getResponse(requestBodyCreate);
        logger.info("status"+responseGACreate.getStatus());
        Assertions.assertEquals(responseGACreate.getStatus(),"200");
        String uid=responseGACreate.getPayload().getUid();
        logger.info(uid);
        String firstName=responseGACreate.getPayload().getFirstName();
        String lastName=responseGACreate.getPayload().getLastName();
        Selenide.open(map.get("RcclUrl"));
        boolean firstNameStatus= new LoginPage().email(uid).password().signIn().popUpTermsAndCondition()
                .popUpPrivacyPolicy().getName(firstName);
        logger.info(firstNameStatus+"****first name status*****");
        Assertions.assertTrue(firstNameStatus);
        String fullName=firstName+" "+lastName;
        logger.info(fullName);
        boolean fullNameStatus=new HomePage().cruiseButton().planNewCruiseButton().APTab().
                profileTab().getFullName(fullName);
        logger.info(fullNameStatus+"***FullName status*****");
    }
}