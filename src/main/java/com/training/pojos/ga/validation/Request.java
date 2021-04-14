package com.training.pojos.ga.validation;

import lombok.Setter;

@Setter
public class Request {
    private String email;

    public Request(String email) {
        setEmail(email);
    }
}
