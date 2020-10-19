package com.training.services.ga.create;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
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
