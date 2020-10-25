package com.training.services.ga.create;

import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
public class RequestBodyCreate {
    private String birthdate;
    private String email;
    private String firstName;
    private String lastName;
    private String marketingCountry;
    private String password;
    private PrivacyPolicyAgreement privacyPolicyAgreement;
    private List<SecurityQuestions>  securityQuestions;
    private SecurityQuestions questions;
    private TermsAndConditionsAgreement termsAndConditionsAgreement;
    private String uidType;

    public RequestBodyCreate(){
        privacyPolicyAgreement=new PrivacyPolicyAgreement();
        termsAndConditionsAgreement=new TermsAndConditionsAgreement();
        securityQuestions=new ArrayList<SecurityQuestions>();
        securityQuestions.add(new SecurityQuestions());
    }

    public void setAcceptDateTime(String acceptDateTime, int i) {
        if(i==1){
            privacyPolicyAgreement.setAcceptDateTime(acceptDateTime);
        }
        termsAndConditionsAgreement.setAcceptDateTime(acceptDateTime);
    }

    public void setVersion(String version, int i) {
        if(i==1){
            privacyPolicyAgreement.setVersion(version);
        }
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