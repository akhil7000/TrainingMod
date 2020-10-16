package com.training.services.ga.authenticate;

import java.util.List;

public class Response {
    String status;
    List<Errors> errors;
    Payload payload;
    Error error;

    public List<Errors> getErrors() {
        return errors;
    }

    public Error getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public Payload getPayload () {
        return payload;
    }
}