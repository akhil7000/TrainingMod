package com.training.services.ga.authenticate;

import lombok.Getter;

@Getter
public class Payload {
    String accountId;
    String firstName;
    String lastName;
    String loginStatus;
    String accessToken;
    String  openIdToken;
    String refreshToken;
    String uid;
}