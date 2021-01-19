package com.assignment;

import java.util.Arrays;

public class Assignment5 {
    public int returnIndex(String [] Players,String indexString) {
        //String [] name = {"Paulo Dybala","Federico","Gianluigi","Ronaldo","Messi"};
        return  Arrays.asList(Players).indexOf(indexString);
    }
}