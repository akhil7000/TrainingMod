package com.training.services.ga.validate;

import java.util.List;

public class Response {
    int status;
    List<Errors> errors;
    Error error;
    Payload payload;

    public Error getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public Payload getPayload() {
        return payload;
    }
}