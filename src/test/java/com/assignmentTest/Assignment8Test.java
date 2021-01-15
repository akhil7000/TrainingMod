package com.assignmentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment8;
public class Assignment8Test {
    @Test
    public void printMiddleNumber(){
    System.out.println(Assignment8.middle());
    Assertions.assertEquals(Assignment8.middle(),250);
    }
}
