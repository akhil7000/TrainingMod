package com.training.services.ga.loyalty;

import lombok.Getter;

@Getter
public class Response {
    int status;
    Object errors;
    com.training.services.ga.loyalty.Payload payload;
}