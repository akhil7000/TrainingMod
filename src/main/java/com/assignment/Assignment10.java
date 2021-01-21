package com.assignment;

import java.util.ArrayList;

public class Assignment10 {
    public ArrayList getOddNumber(int min, int max){

        ArrayList<Integer> oddNumbersArraylist = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (i % 2 == 1) {
                oddNumbersArraylist.add(i);
            }
        }
    return oddNumbersArraylist;
    }
}