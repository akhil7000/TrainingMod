package com.training.services.ga.validate;

public class GAValidationResponse {
    int status;
    Object errors;
    GAValidationValidationPayload payload;

    public Object getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }

    public GAValidationValidationPayload getPayload() {
        return payload;
    }
}