package com.training.services.ga;

public class Errors {
    String errorCode;
    String internalMessage;
    String time;
    String developerMessage;

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getInternalMessage() {
        return internalMessage;
    }

    public String getTime() {
        return time;
    }
}