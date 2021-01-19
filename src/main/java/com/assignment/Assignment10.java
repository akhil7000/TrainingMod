package com.assignment;

import java.util.Arrays;

public class Assignment10 {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i=0;i<10;i++)
        {
            intArray[i]=i+1;
            if (i%2==1){
                System.out.println(i);
            }
        }
        /*for (int i : intArray) {
            intArray[i]=i+1;
            if (i%2==1){
                System.out.println(i);
            }*/
        }
    }
