package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Assignment3Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void getCharacterIndex(){
    Assignment3 indexCharacter=new Assignment3();
    logger.info(Integer.toString(indexCharacter.getIndex('X')));
    logger.info(Integer.toString(indexCharacter.getIndex('a')));
    logger.info(Integer.toString(indexCharacter.getIndex('o')));
    Assertions.assertEquals(indexCharacter.getIndex('X'),0);
    Assertions.assertEquals(indexCharacter.getIndex('a'),3);
    Assertions.assertEquals(indexCharacter.getIndex('o'),2);
    }
}
