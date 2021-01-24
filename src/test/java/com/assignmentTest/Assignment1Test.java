package com.assignmentTest;

import java.lang.*;
import java.util.Iterator;

import com.assignment.Assignment1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment1Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testCovertDataType() {
        Assignment1 assignment1 = new Assignment1();
        Object object = null;
        /**
         * int to double
         */
        object=2;
        assignment1.getDoubleFromInt((Integer) object);
        logger.info(object.getClass().getName());
        Assertions.assertTrue(object.getClass().getName()=="java.lang.Integer","Datatype doesn't match");

        /**
         * double to int
         */
        object=2.3d;
        assignment1.getIntFromDouble((Double) object);
        logger.info(object.getClass().getName());


        /**
         *
         */
    }
}
