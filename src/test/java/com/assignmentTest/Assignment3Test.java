package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment3;
public class Assignment3Test {

    @Test
    public void getCharacterIndex(){
    Assignment3 indexCharacter=new Assignment3();
    System.out.println(indexCharacter.getIndex('X'));
    System.out.println(indexCharacter.getIndex('a'));
    System.out.println(indexCharacter.getIndex('o'));
    Assertions.assertEquals(indexCharacter.getIndex('X'),0);
    Assertions.assertEquals(indexCharacter.getIndex('a'),3);
    Assertions.assertEquals(indexCharacter.getIndex('o'),2);

    }
}
