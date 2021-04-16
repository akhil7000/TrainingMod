package com.training.pojos.ga.creation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecurityQuestion {
    @Builder.Default private String answer="Answer1";
    @Builder.Default private String question="What was the first concert you attended?";
    @Builder.Default private String questionKey="WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED";
}
