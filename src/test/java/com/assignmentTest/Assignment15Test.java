package com.assignmentTest;

import com.assignment.Assignment15;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment15Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetFullName() {
        Assignment15 assignment15 = new Assignment15();
        logger.info(assignment15.fullName("Barrack"));
        logger.info(assignment15.fullName("Barrack", "Obama"));
        logger.info(assignment15.fullName("Barrack", "Hussain", "Obama"));
    }
}
