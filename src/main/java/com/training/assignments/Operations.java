package com.training.assignments;

import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Operations {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void printCompanyReviews(){
         Scanner input = new Scanner(System.in);
        System.out.println("Please enter companyname: ");
        String companyName = input.nextLine();
        logger.info("You have entered: "+companyName+":");
        switch(companyName)
        {
            case "Endee engineers":
                logger.info("good company for production of portable and online instrument of gas analyzer");
                break;
            case "Aaion automation":
                logger.info("installation of GPS tracker");
                break;
            case "Thermolab":
                logger.info("good company for production of stabilizers and incubator");
                break;
            case "Shreeji solution and services":
                logger.info("provide solutions of fire alarm system");
                break;
            case "Google":
                logger.info("Best platform where u will get solution for everything");
                break;
            default:
                logger.info("All companies are good");
        }
    }

    public void conditionCheckUsingIf(String people){
        if(people =="good") {
            logger.info("go to heaven");
        } else if(people == "very good"){
            logger.info("go to heaven with dog");
        } else if(people == "Bad"){
            logger.info("go to hell");
        }
    }

    public void printNumbers(){
        for(int i=1;i<500;i++){
            logger.info("value of i is-->"+i);
        }
    }

    public void printEvenNumbers(){
        int j=1;
        while(j <=100){
            if(j%2==0){
                logger.info("the even number between 1 to 100 is-->"+j);
            }
            j++;
        }
    }

    public void  printUsingForEach(int[] array){
        for(int k:array){
            if((k%2)!=0){
                logger.info("the odd number between 1 to 10 is-->"+k);
            }
            k++;
        }
    }

    @Test
    public void shouldTakeUserInput() {
        InputOutput inputOutput= new InputOutput();

        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        softassert.assertEquals("add 5", inputOutput.getInput());
    }
}