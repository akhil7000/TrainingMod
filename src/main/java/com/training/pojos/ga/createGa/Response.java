package com.training.pojos.ga.createGa;

import lombok.Data;
import java.util.List;

@Data
public class Response {
        private int status;
        private List<Object> errors;
        private Payload payload;
}
