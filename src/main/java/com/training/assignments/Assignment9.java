package com.training.assignments;

import java.util.ArrayList;
import java.util.List;

public class Assignment9 {
    public List<Integer> getEvenNumber(int x, int y) {
        List<Integer> evenList = new ArrayList<>();
        while (x < y) {
            if (x % 2 == 0) {
                evenList.add(x);
            }
            x++;
        }
        return evenList;
    }
}
