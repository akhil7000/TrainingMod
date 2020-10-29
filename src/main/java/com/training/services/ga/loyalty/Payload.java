package com.training.services.ga.loyalty;

import lombok.Getter;

@Getter
public class Payload {
    private String loyaltyId;
    private String loyaltyTier;
    private String relationshipPoints;
    private String individualPoints;
}