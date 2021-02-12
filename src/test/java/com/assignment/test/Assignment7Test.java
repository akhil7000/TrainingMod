package com.assignment.test;

import com.training.sample.pages.assignment.Assignment7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment7Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testWillGoToHeavenOrHell() {
        Assignment7 assignment7 = new Assignment7();

        logger.info(assignment7.getWhereUserWillGo("very good"));
        Assertions.assertEquals(assignment7.getWhereUserWillGo("very good"), "Go to heaven with dogs",
                "Please enter proper parameters");
    }
}