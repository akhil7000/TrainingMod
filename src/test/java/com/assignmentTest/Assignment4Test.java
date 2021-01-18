package com.assignmentTest;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment4;
import org.junit.jupiter.api.Test;

public class Assignment4Test {
    @Test
    public void substring(){
        Assignment4 Test = new Assignment4();
        System.out.println(Test.getSubString("Indian Oil Corporation Ltd","Corporation"));
        Assertions.assertEquals(Test.getSubString("Indian Oil Corporation Ltd","Corporation"),"Corporation");
    }
}
