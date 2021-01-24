package com.assignmentTest;

import java.lang.*;

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
        String errorMessage = "Datatype doesn't match";
        String name = "rccl";

        /**
         * int to double
         */
        object = 2;
        object = assignment1.getDoubleFromInt((Integer) object);
        logger.info(object.getClass().getSimpleName());
        Assertions.assertEquals(object.getClass().getSimpleName(), "Double", errorMessage);

        /**
         * double to int
         */
        object = 200d;
        object = assignment1.getIntFromDouble((Double) object);
        logger.info(object.getClass().getSimpleName());
        Assertions.assertEquals(object.getClass().getSimpleName(), "Integer", errorMessage);

        /**
         *  double to float
         */
        object = 200d;
        object = assignment1.getFloatFromDouble((Double) object);
        logger.info(object.getClass().getSimpleName());
        Assertions.assertEquals(object.getClass().getSimpleName(), "Float", errorMessage);

        /**
         * float to double
         */
        object = 5.5f;
        object = assignment1.getDoubleFromFloat((Float) object);
        logger.info(object.getClass().getSimpleName());
        Assertions.assertEquals(object.getClass().getSimpleName(), "Double", errorMessage);

        /**
         * byte to long
         */


        /**
         * long to byte
         */
        object = 15L;
        object = assignment1.getByteFromLong((Long) object);
        logger.info(object.getClass().getSimpleName());
        Assertions.assertEquals(object.getClass().getSimpleName(), "Byte", errorMessage);

        /**
         * String to char array
         */
        char[] charArray = assignment1.getCharacterArray(name);
        for (int x = 0; x < charArray.length; x++) {
            logger.info(String.valueOf(charArray[x]));
            Assertions.assertEquals(charArray[x], name.charAt(x), errorMessage);
        }
    }
}