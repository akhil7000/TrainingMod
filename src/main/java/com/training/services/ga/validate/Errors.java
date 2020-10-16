package com.training.services.ga.validate;

import lombok.Getter;

@Getter
public class Errors {
    String internalMessage;
    String errorCode;
    String id;

    public String getInternalMessage() {
        return internalMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getId() {
        return id;
    }

}