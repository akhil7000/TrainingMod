package com.training.services.ga.authenticate;

import lombok.Setter;

import java.util.List;

@Setter
public class RequestBodyCreate {
    String birthdate;
    String email;
    String firstName;
    String lastName;
    String marketingCountry;
    String password;
    PrivacyPolicyAgreement privacyPolicyAgreement;
    List<SecurityQuestions> securityQuestions;
    TermsAndConditionsAgreement termsAndConditionsAgreement;
    String uidType;
}
