package com.training.services.ga.validate;

import lombok.Getter;

import java.util.List;

@Getter
public class Response {
    int status;
    List<Errors> errors;
    Error error;
    Payload payload;
}