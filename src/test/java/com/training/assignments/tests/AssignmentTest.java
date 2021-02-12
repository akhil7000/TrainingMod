package com.training.assignments.tests;

import com.training.assignments.Addition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssignmentTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAdditionUsingInterface() {
        int intToAdd = 1;
        Addition addition = new Addition();

        logger.info(Integer.toString(addition.getSum(intToAdd)));
        Assertions.assertEquals(addition.getSum(intToAdd), 3,
                "Sum is not correct");
    }
}