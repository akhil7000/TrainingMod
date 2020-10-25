package com.training.services.ga.authenticate;

import lombok.Getter;
import java.util.List;

@Getter
public class Response {
    private String status;
    private List<Errors> errors;
    private Payload payload;
    private Error error;
}