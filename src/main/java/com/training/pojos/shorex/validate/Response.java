package com.training.pojos.shorex.validate;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private int status;
    private List<Errors> errors;
    private com.training.pojos.shorex.validate.Payload payload;
}
