package com.assignment;

import java.util.ArrayList;

public class Assignment9 {

    public ArrayList getEvenNumber(int min, int max) {
        ArrayList<Integer> evenNumberList = new ArrayList<>();
        while (min <= max) {
            if (min % 2 == 0) {
                evenNumberList.add(min);
            }
            min++;
        }
        return evenNumberList;
    }
}