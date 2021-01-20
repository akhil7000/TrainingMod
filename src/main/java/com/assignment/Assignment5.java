package com.assignment;

import java.util.Arrays;

public class Assignment5 {
    public int getPlayerIndex(String [] players,String indexString) {
    return  Arrays.asList(players).indexOf(indexString);
    }
}