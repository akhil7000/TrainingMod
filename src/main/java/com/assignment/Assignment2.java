package com.assignment;

public class Assignment2 {
    public static String getReplacedCharacter(String originalString,char characterToBeReplaced, char replacement){
        return originalString.replace(characterToBeReplaced,replacement);
    }
    public static String getReplacedSubString(String originalString,String subStringToBeReplaced, String replacement){
        return originalString.replace(subStringToBeReplaced,replacement);
    }

}



