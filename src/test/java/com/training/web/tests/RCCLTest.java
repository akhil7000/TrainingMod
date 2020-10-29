package com.training.web.tests;

import com.codeborne.selenide.Selenide;
import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.create.RequestBodyCreate;
import com.training.utilities.RestEngine;
import com.training.web.pages.rccl.HomePage;
import com.training.web.pages.rccl.LoginPage;
import com.training.web.pages.rccl.ProfilePage;
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
    public void  testUserUIValidate(){
        Response responseGACreate= getResponse(requestBodyCreate);
        logger.info("status"+responseGACreate.getStatus());
        Assertions.assertEquals(responseGACreate.getStatus(),"200");
        String uid=responseGACreate.getPayload().getUid();
        logger.info(uid);
        String responseFirstName=responseGACreate.getPayload().getFirstName();
        String responseLastName=responseGACreate.getPayload().getLastName();
        Selenide.open(map.get("RcclUrl"));
        new LoginPage().email(uid).password().signIn();
        HomePage homePage=new HomePage().popUpTermsAndCondition().popUpPrivacyPolicy();
        String uiFirstName=homePage.getName();
        logger.info(uiFirstName+"****uifirstName*****");
        softAssert.assertThat(uiFirstName.equals(responseFirstName))
                .as("firstName of ui and response are not equal");
        ProfilePage profilePage=homePage.clickCruiseButton().planNewCruiseButton().apTab().profileTab();
        String uiFullName=profilePage.getUiFullName();
        logger.info(uiFullName+"***uiFullName*****");
        String responseFullName=responseFirstName+" "+responseLastName;
        logger.info(responseFullName);
        softAssert.assertThat(uiFullName.equals(responseFullName))
                .as("fullName of ui and response are not equal");
    }
}