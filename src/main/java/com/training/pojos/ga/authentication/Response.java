package com.training.pojos.ga.authentication;

import lombok.Data;

import java.util.List;

@Data
public class Response {
   private int status;
   private List<Errors> errors;
   private Payload payload;
   private com.training.pojos.ga.authentication.Error error;
}
