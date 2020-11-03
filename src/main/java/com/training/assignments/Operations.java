package com.training.assignments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;

public class Operations  {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String printCompanyReviews(String companyName){
        HashMap<String,String> company=new HashMap<>();
        company.put("Endee engineers","good company for production of portable and online instrument of gas analyzer");
        company.put("Aaion automation","installation of GPS tracker");
        company.put("Thermolab","good company for production of stabilizers and incubator");
        company.put("Shreeji solution and services","provide solutions of fire alarm system");
        company.put("Google","Best platform where u will get solution for everything");
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
        return company.get(companyName);
    }

    public String conditionCheckUsingIf(String people){
        HashMap<String,String> behaviour=new HashMap();
        behaviour.put("good","go to heaven");
        behaviour.put("very good","go to heaven with dog");
        behaviour.put("Bad","go to hell");
        behaviour.put("Very Bad","go to hell");

        if(people == "good") {
            logger.info("go to heaven");
        } else if(people == "very good"){
            logger.info("go to heaven with dog");
        } else if(people == "Bad"){
            logger.info("go to hell");
        }else if(people == "Very Bad"){
            logger.info("go to hell");
        }
        return behaviour.get(people);
    }

    public int getMiddleNumber(int number) {
        int index;
        for ( index = 1; index < number; index++) {
            if (number / index == 250) {
                logger.info("value of middle number is-->" + number / index);
                break;
            }
        }
        return number / index;
    }

    public int[] getEvenNumbers(int index){
        int array[]=new int[50];
        int number=0;
        while(index <=100){
            if(index%2==0){
                logger.info("the even number between 1 to 100 is-->"+index);
                array[number]=index;
                number++;
            }
            index++;
        }
        return array;
    }

    public int[]  printOddNumbers(int[] array){
        int arraylimit[]=new int[5];
        int number=0;
        for(int index:array){
            if((index%2)!=0){
                logger.info("the odd number between 1 to 10 is-->"+index);
                arraylimit[number]=index;
                number++;
            }
            index++;
        }
        return arraylimit;
    }
}