package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment3Test {
    Assignment3 assign3=new Assignment3();
    @Test
    public void getIndexTest()
    {
        Assertions.assertEquals(2,assign3.getIndex("Xioami","o"));
    }
}