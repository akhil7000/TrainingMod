package com.training.assignments;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String args[])
    {
        Assignment3 a3=new Assignment3();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("Please enter a string");
            String name = sc.next();
            System.out.println("Please enter the letter to find the index");
            String letter = sc.next();

            System.out.println("index of " + letter + " is" + a3.getIndex(name, letter));
        }
    }
    public int getIndex(String s,String letter)
    {
        return s.indexOf(letter);
    }

}
