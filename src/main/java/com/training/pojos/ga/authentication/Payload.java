package com.training.pojos.ga.authentication;

import lombok.Data;

@Data
public class Payload {
    private String accountId;
    private String accessToken;
    private String uid;
    private String loginStatus;
}
