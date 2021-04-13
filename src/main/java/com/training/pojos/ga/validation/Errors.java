package com.training.pojos.ga.validation;

import lombok.Data;

@Data
public class Errors {
    private String errorCode;
    private String internalMessage;
    private String developerMessage;
}
