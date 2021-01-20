package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment3Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetIndexOfCharacter() {
        Assignment3 assignment3 = new Assignment3();
        String errorMessage = "Character index doesn't match";

        logger.info(Integer.toString(assignment3.getCharacterIndex("Xioami", 'X')));
        Assertions.assertEquals(assignment3.getCharacterIndex("Xioami", 'X'), 0, errorMessage);

        logger.info(Integer.toString(assignment3.getCharacterIndex("Xioami", 'a')));
        Assertions.assertEquals(assignment3.getCharacterIndex("Xioami", 'a'), 3, errorMessage);

        logger.info(Integer.toString(assignment3.getCharacterIndex("Xioami", 'o')));
        Assertions.assertEquals(assignment3.getCharacterIndex("Xioami", 'o'), 2, errorMessage);
    }
}