package com.assignmentTest;
import org.junit.jupiter.api.Assertions;
import com.assignment.Assignment4;
import org.junit.jupiter.api.Test;

public class Assignment4Test {
    @Test
    public void substring(){
        System.out.println(Assignment4.replacement());
        Assertions.assertEquals(Assignment4.replacement(),"Corporation");
    }

}
