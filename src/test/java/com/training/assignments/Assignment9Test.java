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
        evenList.add(2);
        evenList.add(4);

        Assertions.assertEquals(evenList, assignment9.getEvenNumber(1, 5));
    }
}