package com.training.utilities;

public class RequestBody {

   public String getGuestAccountInvalidEmailBody(){
        return "{\"email\": \"testPranav@@api.com\"}";
    }

    public String getGuestAccountWrongEmailBody(){
       return "{\"email\": \"assignment70test@api.com\"}";
    }

    public String getGuestAccountWrongAppKeyBody(){
       return "{\"email\": \"testPranav@api.com\"}";
    }

    public String getGuestAccountValidationBody(){
       return "{\"email\": \"testPranav@api.com\"}";
    }
}