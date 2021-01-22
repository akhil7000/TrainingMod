package com.assignment;

import java.util.ArrayList;

public class Assignment9 {

    public ArrayList getEvenNumber(int min, int max) {
        ArrayList<Integer> evenNumberArray = new ArrayList<>();
        while (min <= max) {
            if (min % 2 == 0) {
                evenNumberArray.add(min);
            }
            min++;
        }
        return evenNumberArray;
    }
}