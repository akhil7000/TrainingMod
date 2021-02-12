package com.assignment.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.training.sample.pages.assignment.Assignment3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment3Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetIndexOfCharacter() {
        Assignment3 assignment3 = new Assignment3();
        String errorMessage = "Character index doesn't match";
        String originalString="Xioami";

        logger.info(Integer.toString(assignment3.getCharacterIndex(originalString, 'X')));
        Assertions.assertEquals(assignment3.getCharacterIndex(originalString, 'X'), 0, errorMessage);

        logger.info(Integer.toString(assignment3.getCharacterIndex(originalString, 'a')));
        Assertions.assertEquals(assignment3.getCharacterIndex(originalString, 'a'), 3, errorMessage);

        logger.info(Integer.toString(assignment3.getCharacterIndex(originalString, 'o')));
        Assertions.assertEquals(assignment3.getCharacterIndex(originalString, 'o'), 2, errorMessage);
    }
}