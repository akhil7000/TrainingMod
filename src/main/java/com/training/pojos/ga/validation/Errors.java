package com.training.pojos.ga.validation;

import lombok.Data;

@Data
public class Errors {
    String errorCode;
    String internalMessage;
    String developerMessage;
}
