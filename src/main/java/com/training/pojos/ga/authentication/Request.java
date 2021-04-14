package com.training.pojos.ga.authentication;

import lombok.Setter;

@Setter
public class Request {
    private String uid;
    private String password;

    public Request(String email, String password) {
        setUid(email);
        setPassword(password);
    }
}
