package com.training.services.ga.create;

import lombok.Getter;

import java.util.List;

@Getter
public class Errors {
    String internalMessage;
    String errorCode;
    String id;
    List<ValidationErrors> validationErrors;
}