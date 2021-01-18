package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment2;
import sun.jvm.hotspot.utilities.Assert;

public class assignment2Test {
    @Test
    public void Test(){
        System.out.println(Assignment2.getReplacedCharacter("Ram",'R','S'));
        Assertions.assertEquals(Assignment2.getReplacedCharacter("Ram",'R','S'),"Sam");
        System.out.println(Assignment2.getReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"));
        Assertions.assertEquals(Assignment2.getReplacedSubString("Sachin Tendulkar","Tendulkar","Masterrrr"),"Sachin Masterrrr");
        System.out.println(Assignment2.getReplacedSubString("Dell","ll","pp"));
        Assertions.assertEquals(Assignment2.getReplacedSubString("Dell","ll","pp"),"Depp");

    }
}
