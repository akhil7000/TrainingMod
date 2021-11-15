package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment1Test {
    Assignment1 assign1 = new Assignment1();

    @Test
    public void intToDoubleTest() {
        Assertions.assertEquals(100.0, assign1.intToDouble(100));
    }

    @Test
    public void doubleToIntTest()
    {
        Assertions.assertEquals(100,assign1.doubleToInt(100.0));
    }

    @Test
    public void doubleToFloatTest()
    {
        Assertions.assertEquals(50.111446f, assign1.doubleToFloat(50.111446));
    }
    @Test
    public void floatToDoubleTest()
    {
        Assertions.assertEquals(20.222000122070312,assign1.floatToDouble(20.222f));
    }
    @Test
    public void byteToLongTest()
    {
        Assertions.assertEquals(126,assign1.byteToLong((byte) 126));
    }
    @Test
    public void longToByteTest()
    {
        Assertions.assertEquals(-54,assign1.longToByte(126232266));
    }
    @Test
    public void stringToCharTest()
    {
        Assertions.assertArrayEquals(
                new char[]{'r','c','c','l'},assign1.stringToChar("rccl"));
    }

}