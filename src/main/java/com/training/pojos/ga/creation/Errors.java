package com.training.pojos.ga.creation;

import lombok.Data;

import java.util.List;

@Data
public class Errors {
    private String errorCode;
    private String internalMessage;
    private String developerMessage;
    private String userMessage;
    private List<com.training.pojos.ga.creation.ValidationErrors> validationErrors;
}