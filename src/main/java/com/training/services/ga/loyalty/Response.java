package com.training.services.ga.loyalty;

import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    int status;
    List<Errors> errors;
    Error error;
    com.training.services.ga.loyalty.Payload payload;
}