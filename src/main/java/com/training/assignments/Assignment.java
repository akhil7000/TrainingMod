package com.training.assignments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assignment {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * dataConversion from one type to another
     */
    public void dataConversion(){
        //int to double and vice-versa
        int number = 55;
        double doubleNumber=number;
        logger.info("converion of int to double-->"+doubleNumber);
        int num=(int)doubleNumber;
        logger.info("converion of double to int-->"+num);
        //double to float and vice-versa
        float floatNumber=(float)doubleNumber;
        logger.info("converion of double to float-->"+floatNumber);
        double dNumber=floatNumber;
        logger.info("converion of float to double-->"+dNumber);
        //long to byte and vice-versa
        long longNum = 11005987L;
        byte byteNum= (byte)longNum;
        logger.info("converion of long to byte = "+byteNum);
        long lNum=byteNum;
        logger.info("converion of byte to long = "+lNum);
    }

    public static void stringToChar(){
        String name="rccl";
        char character[]=name.toCharArray();
        for(int index=0;index<character.length;index++){
            System.out.println(character[index]);
        }
    }

    public void replaceString(){
        //Ram to Sam
        String name="Ram";
        String replacedString=name.replace('R','S');
        logger.info("after replacing String R to S-->"+replacedString);
        //Sachin Tendulkar to Sachin Masterrrr
        String cricketer="Sachin Tendulkar";
        String replacedWord=cricketer.replace("Tendulkar","Masterrrr");
        logger.info("after replacing word Tendulkar to Masterrrr-->"+replacedWord);
        //Dell to Depp
        String laptop="Dell";
        String replacedCharacter=laptop.replace('l','p');
        logger.info("after replacing character l to p-->"+replacedCharacter);
    }

    public void stringOperation(){
        // index of x,a,o
        String name="Xioami";
        int indexOfXCharacter=name.indexOf("X");
        int indeaxOfACharacter=name.indexOf("a");
        int indexOfOCharacter=name.indexOf("o");
        logger.info("index of x-->"+indexOfXCharacter+" "+"index of a-->"+indeaxOfACharacter+" "+"index of o-->"+" "+indexOfOCharacter);
        String companyName = "Indian Oil Corporation Ltd";
        String afterSubstringCompanyName = companyName.substring(11, 22);
        logger.info("after substring-->"+afterSubstringCompanyName);
    }

    public static void main(String[] args) {
        Assignment assignment=new Assignment();
        assignment.dataConversion();
        stringToChar();
        assignment.replaceString();
        assignment.stringOperation();
        Operations operation=new Operations();
        String[] strArray= {"Paulo Dybala","Federico","Gianluigi","Ronaldo","Messi"};
        String strFind="Ronaldo";
        int indexOfName=operation.searchNameFromArray(strArray,strFind);
        System.out.println("index value-->"+indexOfName);
    }
}