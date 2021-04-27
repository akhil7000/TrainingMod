package com.training.pojos.ga.update;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    @Builder.Default private Header header = Header.builder().build();
    private String vdsId;
    @Builder.Default private String lastName="Poole";
    @Builder.Default private String loyaltyId="137529822";
    @Builder.Default private String birthdate="19620802";
}
