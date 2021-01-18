package com.assignmentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment8;
public class Assignment8Test {

    @Test
    public void getMiddleNumber(){
    Assignment8 Test =new Assignment8();
    System.out.println(Test.getMiddleNumber());
    Assertions.assertEquals(Test.getMiddleNumber(),250,"Its not the middle number");
    }
}
