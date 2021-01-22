package com.assignment;

import java.util.ArrayList;

public class Assignment9 {

    public ArrayList getEvenNumber(int min, int max) {
        int index = min;
        ArrayList<Integer> evenNumberArray = new ArrayList<>();
        while (index <= max) {
            if (index % 2 == 0) {
                evenNumberArray.add(index);
            }
            index++;
        }
        return evenNumberArray;
    }
}