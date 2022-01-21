package com.training.assignments;

public class Assignment7 {

    public String getNature(String nature) {
        if (nature.equals("Good")) {
            return "Good people should go to heaven";
        } else if (nature.equals("Very good")) {
            return "Very good people should go to heaven with dogs";
        } else if (nature.equals("Bad people")) {
            return "bad people should go to hell";
        } else if (nature.equals("Very bad people")) {
            return "Very bad people should go to hell with cats";
        } else
            throw new RuntimeException("invalid option");

    }
}
