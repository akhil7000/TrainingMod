package com.assignment;

import java.util.Arrays;

public class Assignment5 {
    public static String ronaldo() {
        //Find the index of Ronaldo in the given array
        String [] name = {"Paulo Dybala","Federico","Gianluigi","Ronaldo","Messi"};
        String a = Integer.toString(Arrays.asList(name).indexOf("Ronaldo"));
        return a;
    }
}