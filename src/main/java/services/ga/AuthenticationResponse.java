package services.ga;

public class AuthenticationResponse {
    String status;
    AuthenticateErrors errors[];
    AuthenticationPayload payload;
    AuthenticateError error;

    public AuthenticateErrors getErrors() {
        return errors[0];
    }

    public AuthenticateError getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public AuthenticationPayload getPayload () {
        return payload;
    }
}