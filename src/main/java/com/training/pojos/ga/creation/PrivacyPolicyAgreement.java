package com.training.pojos.ga.creation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrivacyPolicyAgreement {
    @Builder.Default private String acceptDateTime="20190524T090712GMT";
    @Builder.Default private String version="1.11";
}
