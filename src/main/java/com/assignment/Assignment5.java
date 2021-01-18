package com.assignment;

import java.util.Arrays;

public class Assignment5 {
    public static int findIndex(String indexString) {
        String [] name = {"Paulo Dybala","Federico","Gianluigi","Ronaldo","Messi"};
        return  Arrays.asList(name).indexOf(indexString);
    }
}