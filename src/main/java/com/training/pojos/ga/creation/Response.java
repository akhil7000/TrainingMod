package com.training.pojos.ga.creation;

import lombok.Data;

import java.util.List;

@Data
public class Response {
        private int status;
        private List<Errors> errors;
        private Error error;
        private Payload payload;
}
