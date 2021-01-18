package com.assignmentTest;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment4;
import org.junit.jupiter.api.Test;

public class Assignment4Test {
    @Test
    public void substring(){
        System.out.println(Assignment4.getSubString("Indian Oil Corporation Ltd","Corporation"));
        Assertions.assertEquals(Assignment4.getSubString("Indian Oil Corporation Ltd","Corporation"),"Corporation");
    }

}
