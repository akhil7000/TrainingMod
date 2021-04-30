package com.training.pojos.ga.loyalty_update;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Header {
    @Builder.Default private String brand="R";
    @Builder.Default private String channel="web";
}
