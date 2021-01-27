package com.assignmentTest;

import com.assignment.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment13Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testParentChildInheritance() {
        Child child = new Child();

        logger.info(child.getFirstName() + " " + child.getSurname());
        Assertions.assertEquals(child.getFirstName() + " " + child.getSurname(), "Mike Tyson", "Not Mike Tyson");
    }
}