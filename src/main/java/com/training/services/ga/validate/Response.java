package com.training.services.ga.validate;

public class Response {
    int status;
    Object errors;
    Payload payload;

    public Object getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }

    public Payload getPayload() {
        return payload;
    }
}