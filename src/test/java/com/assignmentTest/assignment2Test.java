package com.assignmentTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.assignment.Assignment2;
import sun.jvm.hotspot.utilities.Assert;

public class assignment2Test {
    @Test
    public void Test(){
        System.out.println(Assignment2.stringTest1());
        Assertions.assertEquals(Assignment2.stringTest1(),"Sam");
        System.out.println(Assignment2.stringTest2()) ;
        Assertions.assertEquals(Assignment2.stringTest2(),"Sachin Masterrrr");
        System.out.println(Assignment2.stringTest3());
        Assertions.assertEquals(Assignment2.stringTest3(),"Depp");
    }
}
