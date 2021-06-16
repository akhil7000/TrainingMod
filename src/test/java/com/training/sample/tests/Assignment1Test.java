package com.training.sample.tests;

import com.training.sample.pages.Assignment1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment1Test {
    Assignment1 assignment1 = new Assignment1();

    @Test
    public void testIntToDouble() {
        Assertions.assertEquals(200.0, assignment1.intToDouble(200));
    }

    @Test
    public void testDoubleToInt() {
        Assertions.assertEquals(200, assignment1.doubleToInt(200.0));
    }

    @Test
    public void testDoubleToFloat() {
        Assertions.assertEquals(55.005f, assignment1.doubleToFloat(55.005001068115234));
    }

    @Test
    public void testFloatToDouble() {
        Assertions.assertEquals(55.005001068115234, assignment1.floatToDouble(55.005f));
    }

    @Test
    public void testByteToLong() {
        int x = -128;
        byte b = (byte) x;
        Assertions.assertEquals(-128, assignment1.byteToLong(b));
    }

    @Test
    public void testLongToByte() {
        Assertions.assertEquals(-48, assignment1.longToByte(59863248L));
    }

    @Test
    public void testStringToCharArray() {
        char[] exp = {'r', 'c', 'c', 'l'};
        Assertions.assertArrayEquals(exp, assignment1.stringToCharArray("rccl"));
    }
}
