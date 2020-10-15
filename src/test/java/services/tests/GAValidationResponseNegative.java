package services.tests;

import com.training.services.ga.GAValidationResponseNegativeErrors;

public class GAValidationResponseNegative {
    int status;
    GAValidationResponseNegativeErrors error;
    GAValidationResponseNegativeErrors errors[];

    public int getStatus() {
        return status;
    }

    public GAValidationResponseNegativeErrors getError() {
        return error;
    }

    public GAValidationResponseNegativeErrors getErrors() {
        return errors[0];
    }
}