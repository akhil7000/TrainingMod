package com.training.pojos.shorex.validate;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    public int status;
    public List<Errors> errors;
    public com.training.pojos.shorex.validate.Payload payload;
}
