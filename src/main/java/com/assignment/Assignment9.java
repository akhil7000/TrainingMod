package com.assignment;

import java.util.ArrayList;

public class Assignment9 {

    public ArrayList getEvenNumber(int min, int max) {
        int i = min;
        ArrayList<Integer> evenNumberArray = new ArrayList<>();
        while (i <= max) {
            if (i % 2 == 0) {
                evenNumberArray.add(i);
            }
            i++;
        }
        return evenNumberArray;
    }
}