package com.assignmentTest;

import com.assignment.Assignment15;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment15Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetFullName() {
        String errorMessage = "Not full name";
        String firstName = "Barrack";
        String lastName = "Obama";
        Assignment15 assignment15 = new Assignment15();

        logger.info(assignment15.getFullName(firstName));
        Assertions.assertEquals(assignment15.getFullName(firstName), "Barrack", errorMessage);

        logger.info(assignment15.getFullName(firstName, lastName));
        Assertions.assertEquals(assignment15.getFullName(firstName, lastName), "Barrack Obama", errorMessage);

        logger.info(assignment15.getFullName(firstName, lastName, "Hussain"));
        Assertions.assertEquals(assignment15.getFullName(firstName, lastName, "Hussain"),
                "Barrack Obama Hussain", errorMessage);
    }
}