package com.training.services.ga;

public class GAValidationResponse {
    int status;
    Errors errors[];
    Error error;
    GAValidationValidationPayload payload;

    public Error getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public Errors getErrors() {
        return errors[0];
    }

    public GAValidationValidationPayload getPayload() {
        return payload;
    }
}