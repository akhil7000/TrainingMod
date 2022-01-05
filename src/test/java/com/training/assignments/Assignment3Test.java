package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment3Test {
    Assignment3 assign3=new Assignment3();

    @Test
    public void getIndex1Test()
    {
        Assertions.assertEquals(0,assign3.getIndex("Xioami","X"));
    }

    @Test
    public void getIndex2Test()
    {
        Assertions.assertEquals(3,assign3.getIndex("Xioami","a"));
    }

    @Test
    public void getIndex3Test()
    {
        Assertions.assertEquals(2,assign3.getIndex("Xioami","o"));
    }

}