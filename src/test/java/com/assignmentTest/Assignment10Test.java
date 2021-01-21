package com.assignmentTest;

import com.assignment.Assignment10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class Assignment10Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void printodd() {
        Assignment10 assignment10 = new Assignment10();
        int min = 1;
        int max = 10;
        ArrayList oddNumbers = assignment10.getOddNumber(min, max);
        Iterator iterator = oddNumbers.iterator();
        while (iterator.hasNext()) {
            logger.info((iterator.next()).toString());
        }

        ArrayList<Integer> oddNumbersVerfication = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (i % 2 == 1) {
                oddNumbersVerfication.add(i);
            }
        }

        Assertions.assertArrayEquals(oddNumbers.toArray(), oddNumbersVerfication.toArray(), "Doesnt Match");
    }
}