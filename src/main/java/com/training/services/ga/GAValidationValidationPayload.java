package com.training.services.ga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GAValidationValidationPayload {
    String accountStatus;
    boolean isUid;

    public String getAccountStatus() {
        return accountStatus;
    }

    public boolean getIsUid() {
        return isUid;
    }
}