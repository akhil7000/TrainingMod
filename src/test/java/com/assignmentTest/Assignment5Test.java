package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment5Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetIndexOfPLayer() {
        Assignment5 assignment5 = new Assignment5();
        String Players[] = {"Paulo Dybala", "Federico", "Gianluigi", "Ronaldo", "Messi"};

        logger.info(Integer.toString(assignment5.getPlayerIndex(Players, "Ronaldo")));
        Assertions.assertEquals(assignment5.getPlayerIndex(Players, "Ronaldo"), 3, "Index does not match");
    }
}