package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment5;
import sun.jvm.hotspot.utilities.Assert;

public class Assignment5Test {
    @Test
    public void indexRonaldo(){
        System.out.println(Assignment5.findIndex("Ronaldo"));
        Assertions.assertEquals(Assignment5.findIndex("Ronaldo"),3);
    }
}
