package com.assignment;

import java.util.Arrays;

public class Assignment5 {

    public int returnPlayerIndex(String [] Players,String indexString) {
    return  Arrays.asList(Players).indexOf(indexString);
    }
}