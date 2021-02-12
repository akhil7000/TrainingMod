package com.training.assignments.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.training.assignments.Assignment6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment6Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testCompanyReview() {
        Assignment6 assignment6 = new Assignment6();

        logger.info(assignment6.getCompanyReview("Google"));
        Assertions.assertEquals(assignment6.getCompanyReview("Google"), "Monitors everything", "Enter valid company name");
    }
}
