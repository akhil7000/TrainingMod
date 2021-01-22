package com.assignmentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment8Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testMiddleNumber() {
        int lowerNumber = 1;
        int higherNumber = 500;
        Assignment8 assignment8 = new Assignment8();
        logger.info(Integer.toString(assignment8.getMiddleNumber(lowerNumber, higherNumber)));
        Assertions.assertEquals(assignment8.getMiddleNumber(lowerNumber, higherNumber), 250, "It's not the middle number");
    }
}