package com.training.pojos.ga.authentication;

import lombok.Data;

@Data
public class Response {
   private int status;
   private Errors[] errors;
   private Payload payload;
}
