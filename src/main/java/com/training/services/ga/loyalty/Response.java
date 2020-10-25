package com.training.services.ga.loyalty;

import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    private int status;
    private List<Errors> errors;
    private Error error;
    private com.training.services.ga.loyalty.Payload payload;
}