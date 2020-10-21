package com.training.services.ga.create;

import lombok.Setter;
import java.util.ArrayList;
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
    List<SecurityQuestions>  securityQuestions;
    SecurityQuestions questions;
    TermsAndConditionsAgreement termsAndConditionsAgreement;
    String uidType;

    public RequestBodyCreate(){
        privacyPolicyAgreement=new PrivacyPolicyAgreement();
        termsAndConditionsAgreement=new TermsAndConditionsAgreement();
        securityQuestions=new ArrayList<SecurityQuestions>();
        securityQuestions.add(new SecurityQuestions());
    }

    public void setAcceptDateTime(String acceptDateTime) {
        privacyPolicyAgreement.setAcceptDateTime(acceptDateTime);
        termsAndConditionsAgreement.setAcceptDateTime(acceptDateTime);
    }

    public void setVersion(String version) {
        privacyPolicyAgreement.setVersion(version);
        termsAndConditionsAgreement.setVersion(version);
    }

    public void setAnswer(String answer) {
      securityQuestions.get(0).setAnswer(answer);
    }

    public void setQuestion(String question) {
        securityQuestions.get(0).setQuestion(question);
    }

    public void setQuestionKey(String questionKey) {
        securityQuestions.get(0).setQuestionKey(questionKey);
    }
}