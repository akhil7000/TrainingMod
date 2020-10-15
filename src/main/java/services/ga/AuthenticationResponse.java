package services.ga;

public class AuthenticationResponse {
    String status;
    Object errors;
    AuthenticationPayload payload;

    public String getStatus() {
        return status;
    }

    public Object getErrors() {
        return errors;
    }

    public AuthenticationPayload getPayload() {
        return payload;
    }
}