package com.training.assignments.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.training.assignments.Assignment2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment2Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetReplacedStringFromOriginal() {
        Assignment2 assignment2 = new Assignment2();
        String errorMessage = "String replacement not successful";

        logger.info(assignment2.getReplacedSubString("Ram", "R", "S"));
        Assertions.assertEquals(assignment2.getReplacedSubString("Ram", "R", "S"), "Sam", errorMessage);

        logger.info(assignment2.getReplacedSubString("Sachin Tendulkar", "Tendulkar", "Masterrrr"));
        Assertions.assertEquals(assignment2.getReplacedSubString("Sachin Tendulkar", "Tendulkar", "Masterrrr"), "Sachin Masterrrr", errorMessage);

        logger.info(assignment2.getReplacedSubString("Dell", "ll", "pp"));
        Assertions.assertEquals(assignment2.getReplacedSubString("Dell", "ll", "pp"), "Depp", errorMessage);
    }
}