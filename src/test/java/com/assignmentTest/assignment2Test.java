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
    public void GetReplacedStringFromOriginal(){
    logger.info(Assignment2.returnReplacedSubString("Ram","R","S"));
    logger.info(Assignment2.returnReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"));
    logger.info(Assignment2.returnReplacedSubString("Dell","ll","pp"));
    Assertions.assertEquals(Assignment2.returnReplacedSubString("Ram","R","S"),"Sam","String replacement not successful");
    Assertions.assertEquals(Assignment2.returnReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"),"Sachin Masterrrr","String replacement not successful");
    Assertions.assertEquals(Assignment2.returnReplacedSubString("Dell","ll","pp"),"Depp","String replacement not successful");
    }
}
