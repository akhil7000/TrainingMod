package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment5;
import sun.jvm.hotspot.utilities.Assert;

public class Assignment5Test {
    @Test
    public void indexRonaldo(){
        Assignment5 Test =new Assignment5();
        System.out.println(Test.findIndex("Ronaldo"));
        Assertions.assertEquals(Test.findIndex("Ronaldo"),3);
    }
}
