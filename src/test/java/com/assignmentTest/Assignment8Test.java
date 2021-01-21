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
        Assignment8 assignment8 = new Assignment8();
        logger.info(Integer.toString(assignment8.getMiddleNumber(1, 500)));
        Assertions.assertEquals(assignment8.getMiddleNumber(1, 500), 250, "It's not the middle number");
    }
}