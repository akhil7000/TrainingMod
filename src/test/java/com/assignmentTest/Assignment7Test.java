package com.assignmentTest;
import com.assignment.Assignment7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment7Test {
    @Test
    public void heavenOrHell(){
    System.out.println(Assignment7.whatAreYou("very good"));
    Assertions.assertEquals(Assignment7.whatAreYou("very good"),"Go to heaven with dogs");
    }
}
