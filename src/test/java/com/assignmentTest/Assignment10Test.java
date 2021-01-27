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
        ArrayList<Integer> numberArrayList = assignment10.getNumbersArray(1, 10);
        ArrayList<Integer> oddNumbersArray = assignment10.getOddNumbers(numberArrayList);

        Iterator iterator = oddNumbersArray.iterator();
        while (iterator.hasNext()) {
            logger.info((iterator.next()).toString());
        }

        /**
         * Assertion to check if odd numbers are retrieved correctly
         */
        for (int number : oddNumbersArray) {
            Assertions.assertTrue(number % 2 == 1, "Not Odd");
        }
    }
}