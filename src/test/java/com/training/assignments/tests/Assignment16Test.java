package com.training.assignments.tests;

import com.training.assignments.AdditionOfNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment16Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAdditionUsingAbstract() {
        int integerToSum = 1;
        AdditionOfNumbers additionOfNumbers = new AdditionOfNumbers();

        logger.info(Integer.toString(additionOfNumbers.getSum(integerToSum)));
        Assertions.assertEquals(additionOfNumbers.getSum(integerToSum), 3,
                "Sum is not correct");
    }
}