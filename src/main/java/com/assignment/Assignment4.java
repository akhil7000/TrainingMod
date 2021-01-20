package com.assignment;

public class Assignment4 {

    public String returnSubString(String originalString,String subString) {
        return originalString.substring(originalString.indexOf(subString.charAt(0)),originalString.indexOf(subString.charAt(0))+subString.length());
       }
}