package com.training.services.ga.authenticate;

import lombok.Getter;

@Getter
public class Payload {
    private String accountId;
    private String loginStatus;
    private String uid;
    private String accessToken;
}