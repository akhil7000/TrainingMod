package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment4;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment4Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetSubstring() {
        Assignment4 assignment4 = new Assignment4();
        logger.info(assignment4.getSubString("Indian Oil Corporation Ltd", "Corporation"));
        Assertions.assertEquals(assignment4.getSubString("Indian Oil Corporation Ltd", "Corporation"),
                "Corporation", "String doesn't match");
    }
}