package com.training.services.ga.create;

import lombok.Getter;
import java.util.List;

@Getter
public class Errors {
    String internalMessage;
    String errorCode;
    String time;
    String id;
    String userMessage;
    List<ValidationErrors> validationErrors;
    String developerMessage;
}