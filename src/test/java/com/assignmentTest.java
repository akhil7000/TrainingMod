package com;

import com.assignment.Yes1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class assignmentTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testInterface() {
        int intToAdd = 1;
        Yes1 yes1 = new Yes1();
        logger.info(Integer.toString(yes1.sum(intToAdd)));
        Assertions.assertTrue(yes1.sum(intToAdd) == (1 + 1 + 1),
                "Sum is not correct");
    }
}