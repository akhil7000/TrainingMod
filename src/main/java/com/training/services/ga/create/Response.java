package com.training.services.ga.create;

import lombok.Getter;
import java.util.List;

@Getter
public class Response {
    String status;
    Error error;
    List<Errors> errors;
    Payload payload;
}