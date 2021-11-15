package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Assignment2Test {
    Assignment2 assign2 =new Assignment2();

    @Test
    public void string1Test() {
        String str1="Ram";
        String str2="Sam";
        String str3="Navi";

        Assertions.assertEquals("Sam",assign2.string1(str1,str2));
        Assertions.assertNotEquals("rita",assign2.string1(str1,str3));

    }

}