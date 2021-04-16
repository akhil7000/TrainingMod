package com.training.pojos.ga.creation;

import lombok.Data;

@Data
public class ValidationErrors {
    private String element;
    private String error;
    private String invalidValue;
}