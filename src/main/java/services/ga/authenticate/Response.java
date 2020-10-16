package services.ga.authenticate;

import lombok.Getter;
import java.util.List;

@Getter
public class Response {
    String status;
    List<Errors> errors;
    Payload payload;
    Error error;

    public List<Errors> getErrors() {
        return errors;
    }

    public Error getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public Payload getPayload () {
        return payload;
    }
}