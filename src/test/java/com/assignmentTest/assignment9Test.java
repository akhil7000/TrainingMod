package com.assignmentTest;

import com.assignment.Assignment9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class assignment9Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testEvenNumbers() {
        int min = 1;
        int max = 500;
        Assignment9 assignment9 = new Assignment9();

        ArrayList evenNumbers = assignment9.getEvenNumber(min, max);
        Iterator iterator = evenNumbers.iterator();
        while (iterator.hasNext()) {
            logger.info((iterator.next()).toString());
        }

        //Assertion to check if Array is correct
        ArrayList<Integer> evenNumbersVerfication = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                evenNumbersVerfication.add(i);
            }
        }
        Assertions.assertArrayEquals(evenNumbers.toArray(), evenNumbersVerfication.toArray(), "Doesn't Match");
    }
}