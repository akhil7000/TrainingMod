package com.assignment;
public class Assignment4 {
    public static String replacement() {
        String IOCL = "Indian Oil Corporation Ltd";
        String Corp = IOCL.substring(IOCL.indexOf('C'),IOCL.lastIndexOf('n')+1);
        return Corp;
       }
}