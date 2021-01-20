package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jvm.hotspot.utilities.Assert;

public class Assignment2Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetReplacedStringFromOriginal(){
    Assignment2 assignment2=new Assignment2();
    logger.info(assignment2.returnReplacedSubString("Ram","R","S"));
    logger.info(assignment2.returnReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"));
    logger.info(assignment2.returnReplacedSubString("Dell","ll","pp"));
    Assertions.assertEquals(assignment2.returnReplacedSubString("Ram","R","S"),"Sam","String replacement not successful");
    Assertions.assertEquals(assignment2.returnReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"),"Sachin Masterrrr","String replacement not successful");
    Assertions.assertEquals(assignment2.returnReplacedSubString("Dell","ll","pp"),"Depp","String replacement not successful");
    }
}
