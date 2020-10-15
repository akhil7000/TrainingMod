package services.ga;

public class AuthenticateAppKey {
    String status;
    AuthenticateError error;
    AuthenticateWrongUsername errors[];

    public AuthenticateWrongUsername getErrors() {
        return errors[0];
    }

    public String getStatus() {
        return status;
    }

    public AuthenticateError getError() {
        return error;
    }
}