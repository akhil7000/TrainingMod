package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment3Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGetIndexOfCharacter(){
    Assignment3 assignment3 =new Assignment3();
    logger.info(Integer.toString(assignment3.returnCharacterIndex("Xioami",'X')));
    logger.info(Integer.toString(assignment3.returnCharacterIndex("Xioami",'a')));
    logger.info(Integer.toString(assignment3.returnCharacterIndex("Xioami",'o')));
    Assertions.assertEquals(assignment3.returnCharacterIndex("Xioami",'X'),0,"Character index doesn't match");
    Assertions.assertEquals(assignment3.returnCharacterIndex("Xioami",'a'),3,"Character index doesn't match");
    Assertions.assertEquals(assignment3.returnCharacterIndex("Xioami",'o'),2,"Character index doesn't match");
    }
}
