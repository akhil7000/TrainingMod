package com.training.assignments;
import java.util.Scanner;

public class Tests{
    public static void main(String[] args) {
        Tests c=new Tests();
        c.printCompanyReviews();
    }
    public void printCompanyReviews(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Please enter companyname: ");
        String companyName  = sc.nextLine();
        System.out.println("You have entered: "+companyName+":");
        switch(companyName)
        {
            case "Endee engineers":
                System.out.println("good company for production of portable and online instrument of gas analyzer");
                break;
            case "Aaion automation":
                System.out.println("installation of GPS tracker");
                break;
            case "Thermolab":
                System.out.println("good company for production of stabilizers and incubator");
                break;
            case "Shreeji solution and services":
                System.out.println("provide solutions of fire alarm system");
                break;
            case "Google":
                System.out.println("Best platform where u will get solution for everything");
                break;
            default:
                System.out.println("All companies are good");
        }
    }
}








