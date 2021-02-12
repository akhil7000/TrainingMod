package com.training.assignments;

public class Assignment7 {

    public String getWhereUserWillGo(String quality) {
        if (quality.equals("very good")) {
            return "Go to heaven with dogs";
        } else if (quality.equals("good")) {
            return "Go to heaven";
        } else {
            return "Go to hell";
        }
    }
}