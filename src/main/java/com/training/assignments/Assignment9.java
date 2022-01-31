package com.training.assignments;

import java.util.ArrayList;
import java.util.List;

public class Assignment9 {
    public List<Integer> getEvenNumber(int startRange, int endRange) {
        List<Integer> evenList = new ArrayList<>();
        while (startRange < endRange) {
            if (startRange % 2 == 0) {
                evenList.add(startRange);
            }
            startRange++;
        }
        return evenList;
    }
}
