package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Assignment9Test {
    Assignment9 assignment9 = new Assignment9();

    @Test
    public void testEvenNumber() {
        List<Integer> evenList = new ArrayList<>();
        int startRange=1;
        int endRange=200;

        evenList=assignment9.getEvenNumber(startRange,endRange);
        for (int evenNumber: evenList) {
            Assertions.assertTrue(evenNumber % 2 == 0, "This number is not even");
        }
    }
}