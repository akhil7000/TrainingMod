package com.training.sample.tests;

import com.training.sample.pages.Assignment1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Assignment1Test {
    Assignment1 a1=new Assignment1();
    @Test
    public void intToDoubleTest(){
        double result=a1.intToDouble(200);
        Assertions.assertEquals(200.0,result);
    }
    @Test
    public void doubleToInt(){
        int result=a1.doubleToInt(200.0);
        Assertions.assertEquals(200,result);
    }
    @Test
    public void doubleToFloat(){
        float result=a1.doubleToFloat(55.005001068115234);
        Assertions.assertEquals(55.005f,result);
    }
    @Test
    public void floatToDouble(){
        double result=a1.floatToDouble(55.005f);
        Assertions.assertEquals(55.005001068115234,result);
    }
    @Test
    public void byteToLong(){
        int x=-128;
        byte b=(byte)x;
        long result=a1.byteToLong(b);
        Assertions.assertEquals(-128,result);
    }
    @Test
    public void longToByte(){
        byte result=a1.longToByte(59863248L);
        Assertions.assertEquals(-48,result);
    }
    @Test
    public void stringToCharArray(){
        char[] exp ={'r','c','c','l'};
        char[] result=a1.stringToCharArray("rccl");
        Assertions.assertArrayEquals(exp,result);

    }
}
