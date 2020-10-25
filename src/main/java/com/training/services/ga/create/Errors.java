package com.training.services.ga.create;

import lombok.Getter;
import java.util.List;

@Getter
public class Errors {
    private String internalMessage;
    private String errorCode;
    private String time;
    private String id;
    private String userMessage;
    private List<ValidationErrors> validationErrors;
    private String developerMessage;
}