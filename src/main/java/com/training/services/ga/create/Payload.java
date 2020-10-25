package com.training.services.ga.create;

import lombok.Getter;

@Getter
public class Payload {
    private String accountId;
    private String loginStatus;
    private String uid;
    private String firstName;
    private String lastName;
    private String openIdToken;
    private String refreshToken;
    private String accessToken;
}