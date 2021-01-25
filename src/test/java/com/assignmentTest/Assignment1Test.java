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
    public void testConvertDataType() {
        Assignment1 assignment1 = new Assignment1();
        String errorMessage = "Datatype doesn't match";
        String name = "rccl";

        /**
         * int to double
         */
        Assertions.assertTrue(Integer.class.isInstance(assignment1.getIntFromDouble(21D)),errorMessage);

        /**
         * double to int
         */
        Assertions.assertTrue(Double.class.isInstance(assignment1.getDoubleFromInt(20)),errorMessage);

        /**
         * double to float
         */
        Assertions.assertTrue(Double.class.isInstance(assignment1.getDoubleFromFloat(20f)),errorMessage);

        /**
         * float to double
         */
        Assertions.assertTrue(Float.class.isInstance(assignment1.getFloatFromDouble(20D)),errorMessage);

        /**
         * byte to long
         */
        byte byteValue=2;
        Assertions.assertTrue(Long.class.isInstance(assignment1.getLongFromByte(byteValue)),errorMessage);

        /**
         * long to byte
         */
        Assertions.assertTrue(Byte.class.isInstance(assignment1.getByteFromLong(20L)),errorMessage);

        /**
         * String to char array
         */
        char[] charArray = assignment1.getCharacterArray(name);
        for (int index = 0; index < charArray.length; index++) {
            logger.info(String.valueOf(charArray[index]));
            Assertions.assertEquals(charArray[index], name.charAt(index), errorMessage);
        }
    }
}