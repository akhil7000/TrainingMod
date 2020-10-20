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
    List<SecurityQuestions> securityQuestions;
    TermsAndConditionsAgreement termsAndConditionsAgreement;
    String uidType;

    public RequestBodyCreate(){
        privacyPolicyAgreement=new PrivacyPolicyAgreement();
        termsAndConditionsAgreement=new TermsAndConditionsAgreement();
        securityQuestions=new ArrayList<>();
    }
    public void setAcceptDateTime(String acceptDateTime) {
        privacyPolicyAgreement.setAcceptDateTime(acceptDateTime);
        termsAndConditionsAgreement.setAcceptDateTime(acceptDateTime);
    }

    public void setVersion(String version) {
        privacyPolicyAgreement.setVersion(version);
        termsAndConditionsAgreement.setVersion(version);
    }


    public SecurityQuestions setAnswer(String answer) {
      securityQuestions.add(0,setAnswer(answer));
        return null;
    }


    public SecurityQuestions setQuestion(String question) {
    securityQuestions.add(0,setQuestion(question));
    return null;
    }


    public SecurityQuestions setQuestionKey(String questionKey) {
        securityQuestions.add(0,setQuestionKey(questionKey));
        return null;
    }

//    public void setQuestionKey(String questionKey) {
//        securityQuestions.get(1).setQuestionKey(questionKey);
//    }
}