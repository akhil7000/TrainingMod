package com.training.services.ga.create;

import lombok.Getter;

@Getter
public class Payload {
    String accountId;
    String loginStatus;
    String uid;
    String firstName;
    String lastName;
    String openIdToken;
    String refreshToken;
    String accessToken;
}