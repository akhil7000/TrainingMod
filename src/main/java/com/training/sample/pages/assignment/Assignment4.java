package com.training.sample.pages.assignment;

public class Assignment4 {

    public String getSubString(String originalString, String subString) {
        return originalString.substring(originalString.indexOf(subString.charAt(0)),
                originalString.indexOf(subString.charAt(0)) + subString.length());
    }
}