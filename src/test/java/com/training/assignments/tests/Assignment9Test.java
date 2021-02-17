package com.training.assignments.tests;

import com.training.assignments.Assignment9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class Assignment9Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testEvenNumbers() {
        int min = 1, max = 500;
        ArrayList<Integer> evenNumbers = new Assignment9().getEvenNumber(min, max);
        Iterator iterator = evenNumbers.iterator();

        while (iterator.hasNext()) {
            logger.info((iterator.next()).toString());
        }

        /**
         * Assertion to check if even numbers are retrieved
         */

        for (int i : evenNumbers) {
            Assertions.assertTrue(i % 2 == 0, "Not Even");
        }

    }
}