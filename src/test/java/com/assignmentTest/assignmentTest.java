package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment2;
import sun.jvm.hotspot.utilities.Assert;

public class assignmentTest {
    @Test
    public void Test(){
        Assignment2.stringTest1();
        //Assertions.assertTrue(Assignment2.stringTest1(),"Sam");
        Assignment2.stringTest2();
        Assignment2.stringTest3();
    }
}
