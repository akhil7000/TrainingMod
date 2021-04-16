package com.training.pojos.ga.creation;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Request {
    @Builder.Default private String birthdate="19620802";
    @Builder.Default private String email="testemail@email.com";
    @Builder.Default private String firstName = "Audrey";
    @Builder.Default private String lastName="Poole";
    @Builder.Default private String marketingCountry="USA";
    @Builder.Default private String password="Password1";
    @Builder.Default private PrivacyPolicyAgreement privacyPolicyAgreement
                                                    = PrivacyPolicyAgreement.builder().build();
    @Builder.Default private List<SecurityQuestion> securityQuestions
                                                    = Arrays.asList(SecurityQuestion.builder().build());
    @Builder.Default private TermsAndConditionsAgreement termsAndConditionsAgreement
                                                    = TermsAndConditionsAgreement.builder().build();
    @Builder.Default private String uidType="EMAIL";
}