package com.training.pojos.ga.createGa;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Request {
    private String birthdate;
    private String email;
    private String firstName;
    private String lastName;
    private String marketingCountry;
    private String password;
    private PrivacyPolicyAgreement privacyPolicyAgreement;
    private List<SecurityQuestion> securityQuestions;
    private TermsAndConditionsAgreement termsAndConditionsAgreement;
    private String uidType;

    public Request(){
        privacyPolicyAgreement = new PrivacyPolicyAgreement();
        termsAndConditionsAgreement = new TermsAndConditionsAgreement();
        securityQuestions = new ArrayList<>();
        securityQuestions.add(new SecurityQuestion());
    }

    public void setPrivacyAcceptDateTime(String dateTime){
        privacyPolicyAgreement.setAcceptDateTime(dateTime);
    }

    public void setPrivacyVersion(String verison){
        privacyPolicyAgreement.setVersion(verison);
    }

    public void setTncAcceptDateTime(String dateTime){
        termsAndConditionsAgreement.setAcceptDateTime(dateTime);
    }

    public void setTncVersion(String version){
        termsAndConditionsAgreement.setVersion(version);
    }

    public void setSecurityQuestion(String question){
        securityQuestions.get(0).setQuestion(question);
    }

    public void setSecurityAnswer(String answer){
        securityQuestions.get(0).setAnswer(answer);
    }

    public void setSecurityQuestionKey(String key){
        securityQuestions.get(0).setQuestionKey(key);
    }


}

