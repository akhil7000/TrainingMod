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
    public void testPrintOdd() {
        Assignment10 assignment10 = new Assignment10();
        int min = 1, max = 10;
        ArrayList<Integer> oddNumbersArray = assignment10.getOddNumbers(min, max);

        Iterator iterator = oddNumbersArray.iterator();
        while (iterator.hasNext()) {
            logger.info((iterator.next()).toString());
        }

        /**
         * Assertion to check if odd numbers are retrieved correctly
         */

        for (int i : oddNumbersArray) {
            Assertions.assertTrue(i % 2 == 1, "Not Even");
        }
    }
}