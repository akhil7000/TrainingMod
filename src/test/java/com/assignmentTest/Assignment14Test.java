package com.assignmentTest;

import com.assignment.Actor;
import com.assignment.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment14Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testWorkAction() {
        String errorMessage = "Action doesn't Match";
        Actor actor = new Actor();
        Director director = new Director();

        logger.info(actor.work());
        Assertions.assertEquals(actor.work(), "Doing Acting", errorMessage);

        logger.info(director.work());
        Assertions.assertEquals(director.work(), "Directing", errorMessage);
    }
}