package com.training.services.ga.create;

import lombok.Getter;
import java.util.List;

@Getter
public class Response {
    private String status;
    private Error error;
    private List<Errors> errors;
    private Payload payload;
}