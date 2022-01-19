package com.training.assignments;

public class Assignment4 {
    public String getSubstring(String sentence, int startIndex, int endIndex) {
        if (endIndex <= sentence.length() && startIndex < endIndex) {
            return sentence.substring(startIndex, endIndex);
        }
        return "invalid data";
    }
}

