package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.create.RequestBodyCreate;
import com.training.services.ga.create.Response;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.*;
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
    String uid=getUniqueMailId();
    String firstName="Audrey";
    String lastName="Poole";

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
     * @param requestBodyCreate:accept request in pojo format
     * @return :response
     */
    public Response getResponse(RequestBodyCreate requestBodyCreate){
        return  new RestEngine().getResponsePost(map.get("URI")
                , headerMap
                ,new Gson().toJson(requestBodyCreate)).as(Response.class);
    }

    /**
     * testGuestCreation():request body implemented using POJO concept to get the +ve reponse ie 200
     */
    @Test
    public void  testGuestCreation(){
        Response responseGACreate= getResponse(requestBodyCreate);
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
     * testWrongMailGuestCreation():passing wrong mail in reqest body using POJO
     * to get response status 422
     */
    @Test
    public void  testWrongMailGuestCreation(){
        requestBodyCreate.setEmail(uid+"@@@api.net");
        Response  responseGACreate= getResponse(requestBodyCreate);
        logger.info("status->"+responseGACreate.getStatus());
        logger.info("errors->"+responseGACreate.getErrors().get(0).getInternalMessage());
        logger.info("errors->"+responseGACreate.getErrors().get(0).getErrorCode());
        logger.info("error->validatingErrors-->"+responseGACreate.getErrors().get(0).getValidationErrors()
                .get(0).getElement());
        logger.info("error->validatingErrors-->"+responseGACreate.getErrors().get(0).getValidationErrors()
                .get(0).getInvalidValue());
        Assertions.assertEquals(responseGACreate.getStatus(),"422");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getErrorCode()).isEqualTo("GA-0103");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getValidationErrors().get(0)
                .getError()).isEqualTo("The email is invalidly formatted.");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getValidationErrors().get(0)
                .getInvalidValue()).isEqualTo(uid+"@@@api.net");
    }

    /**
     * testWrongAppKeyGuestCreation():passing wrong Appkey in request body using POJO
     * to get response status 401
     */
    @Test
    public void  testWrongAppKeyGuestCreation() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyWrongValue"));
        Response responseGACreate= getResponse(requestBodyCreate);
        logger.info("status->" +responseGACreate.getStatus());
        logger.info("error code->"+responseGACreate.getErrors().get(0).getErrorCode());
        logger.info("IntegerMessage"+responseGACreate.getErrors().get(0).getInternalMessage());
        Assertions.assertEquals(responseGACreate.getStatus(),"401");
        softAssert.assertThat(responseGACreate.getError().getErrorCode()).isEqualTo("COMMONS-0001");
        softAssert.assertThat(responseGACreate.getError().getMessage()).
                isEqualTo("The API key header is required and the API key provided should be valid.");
        responseGACreate.getErrors().get(0).getErrorCode();
        softAssert.assertThat(responseGACreate.getErrors().get(0).getErrorCode()).isEqualTo("COMMONS-0001");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getInternalMessage()).
                isEqualTo("The API key header is required and should be valid.");
    }

    /**
     * testWrongPasswordGuestCreation():passing wrong Password(3-digits) in request body using
     * POJO to get response status 422
     */
    @Test
    public void  testWrongPasswordGuestCreation() {
        requestBodyCreate.setPassword("Pass");
        Response responseGACreate= getResponse(requestBodyCreate);
        logger.info("status->" + responseGACreate.getStatus());
        logger.info("errorcode"+responseGACreate.getErrors().get(0).getErrorCode());
        logger.info("userrMessage"+responseGACreate.getErrors().get(0).getUserMessage());
        logger.info("validation errors->element->"+responseGACreate.getErrors()
                .get(0).getValidationErrors().get(0).getElement());
        logger.info("validation errors->error->"+responseGACreate.getErrors()
                .get(0).getValidationErrors().get(0).getError());
        logger.info("validation errors->invalid-value->"+responseGACreate.getErrors()
                .get(0).getValidationErrors().get(0).getInvalidValue());
        Assertions.assertEquals(responseGACreate.getStatus(),"422");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getErrorCode()).isEqualTo("GA-0103");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getUserMessage()).
                isEqualTo("Your request is invalid.");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getValidationErrors().get(0).getError())
                .contains("The password must be between [8] and [32] characters, inclusive, with at least [1] letters and [1] numbers.");
    }

    /**
     * testExistingMailGuestCreation():passing Existing mail in reqest body using POJO to get
     * response status 400
     */
    @Test
    public void  testExistingMailGuestCreation(){
        requestBodyCreate.setEmail("testShrikant56789888668@api.com");
        Response responseGACreate= getResponse(requestBodyCreate);
        logger.info("status->"+responseGACreate.getStatus());
        logger.info("DeveloperMessage->errors->"+responseGACreate.getErrors().get(0).getDeveloperMessage());
        logger.info("errors->"+responseGACreate.getErrors().get(0).getErrorCode());
        logger.info("InternalMessage->errors->"+responseGACreate.getErrors().get(0).getInternalMessage());
        Assertions.assertEquals(responseGACreate.getStatus(),"400");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getDeveloperMessage()).
                isEqualTo("An existing account was found with the given details.");
        softAssert.assertThat(responseGACreate.getErrors().get(0).getErrorCode()).
                isEqualTo("GA-0101");
    }
}