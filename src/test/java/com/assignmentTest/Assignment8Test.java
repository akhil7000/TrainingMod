package com.assignmentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment8;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment8Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getMiddleNumber(){
    Assignment8 assignment8 =new Assignment8();
    System.out.println(assignment8.return_Middle_Number(1,500));
    Assertions.assertEquals(assignment8.return_Middle_Number(1,500),249,"Its not the middle number");
    }
}
