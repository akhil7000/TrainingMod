package com.assignmentTest;
import com.assignment.Assignment7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment7Test {

    @Test
    public void heavenOrHell(){
   Assignment7 Test=new Assignment7();
    System.out.println(Test.whatAreYou("very good"));
    Assertions.assertEquals(Test.whatAreYou("very good"),"Go to heaven with dogs");
    }
}
