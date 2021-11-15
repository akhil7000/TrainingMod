package com.training.assignments;

import java.util.Scanner;

public class Assignment2 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the two strings which is to be replaced");
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        Assignment2 a2=new Assignment2();

        String s=a2.string1(str1,str2);
        System.out.println("The string after it is replaced is "+s);

    }
    public String string1 (String str1,String str2) {

        str1=str1.replaceAll(str1,str2);
        return str1;
    }
}
