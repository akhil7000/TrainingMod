package com.assignment;

//Printing middle number
public class Assignment8 {
    public static int middle(){
        int[] arrayM = new int[500];
        for(int i=0; i<500; i++) {
            arrayM[i]=i+1;
        }
        int middleNumber = (arrayM.length)/2;
        return middleNumber;

    }
}