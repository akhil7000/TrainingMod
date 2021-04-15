package com.training.pojos.ga.creation;

import lombok.Data;

@Data
public class Payload {
    private String accessToken;
    private String accountId;
    private String firstName;
    private String lastName;
    private String loginStatus;
    private String openIdToken;
    private String refreshToken;
    private int tokenExpiration;
    private String uid;
}
