package com.training.pojos.ga.authentication;

import lombok.Data;

@Data
public class Errors {
    private String developerMessage;
    private String errorCode;
    private String internalMessage;
}
