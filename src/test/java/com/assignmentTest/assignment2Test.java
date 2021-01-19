package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jvm.hotspot.utilities.Assert;

public class assignment2Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void stringReplacement(){
        logger.info(Assignment2.getReplacedSubString("Ram","R","S"));
        logger.info(Assignment2.getReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"));
        logger.info(Assignment2.getReplacedSubString("Dell","ll","pp"));
        Assertions.assertEquals(Assignment2.getReplacedSubString("Ram","R","S"),"Sam");
        Assertions.assertEquals(Assignment2.getReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"),"Sachin Masterrrr");
        Assertions.assertEquals(Assignment2.getReplacedSubString("Dell","ll","pp"),"Depp");
    }
}
