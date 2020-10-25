package com.training.services.ga.validate;

import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    private int status;
    private List<Errors> errors;
    private Error error;
    private Payload payload;
}