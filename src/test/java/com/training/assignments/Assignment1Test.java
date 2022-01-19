package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Assignment1Test {
    Assignment1 assignment1 = new Assignment1();

    @Test
    public void testIntToDouble() {
        Assertions.assertEquals(100.0, assignment1.getIntToDouble(100));
    }

    @Test
    public void testDoubleToInt() {
        Assertions.assertEquals(100, assignment1.getDoubleToInt(100.0));
    }

    @Test
    public void testDoubleToFloat() {
        Assertions.assertEquals(50.111446f, assignment1.getDoubleToFloat(50.111446));
    }

    @Test
    public void testFloatToDouble() {
        Assertions.assertEquals(20.222000122070312, assignment1.getFloatToDouble(20.222f));
    }

    @Test
    public void testByteToLong() {
        Assertions.assertEquals(126, assignment1.getByteToLong((byte) 126));
    }

    @Test
    public void testLongToByte() {
        Assertions.assertEquals(-54, assignment1.getLongToByte(126232266));
    }

    @Test
    public void testStringToChar() {
        Assertions.assertArrayEquals(
                new char[]{'r', 'c', 'c', 'l'}, assignment1.getStringToChar("rccl"));
    }
}