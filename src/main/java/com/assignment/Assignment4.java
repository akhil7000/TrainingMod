package com.assignment;
public class Assignment4 {
    public static String getSubString(String originalString,String subString) {
        /*String IOCL = "Indian Oil Corporation Ltd";
        String Corp = IOCL.substring(IOCL.indexOf('C'),IOCL.lastIndexOf('n')+1);
        ,subString.charAt(0)+subString.length()*/
        return originalString.substring(originalString.indexOf(subString.charAt(0)),originalString.indexOf(subString.charAt(0))+subString.length());
       }
}