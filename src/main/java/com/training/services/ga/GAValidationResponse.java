package com.training.services.ga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GAValidationResponse {
    int status;
    Object error;
    GAValidationValidationPayload payload;

    public int getStatus() {
        return status;
    }

    public Object getError() {
        return error;
    }

    public GAValidationValidationPayload getPayload() {
        return payload;
    }
}