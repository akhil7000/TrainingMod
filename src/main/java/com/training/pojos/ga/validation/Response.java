package com.training.pojos.ga.validation;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private int status;
    private List<Errors> errors;
    private Payload payload;
    private Error error;
}
