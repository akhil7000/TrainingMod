package com.training.assignments;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Assignment {

    public double getDoubleFromInt(int number){
        double doubleNumber=number;
        return doubleNumber;
    }

    public int getIntFromDouble(double doubleNumber){
        int intNumber =(int)doubleNumber;
        return intNumber;
    }

    public float getFloatFromDouble(double doubleNumber){
        float floatNumber =(float)doubleNumber;
        return floatNumber;
    }

    public double getDoubleFromFloat(float floatNumber){
        double doubleNumber =floatNumber;
        return doubleNumber;
    }

    public byte getByteFromLong(long longNumber){
        byte byteNumber =(byte)longNumber;
        return byteNumber;
    }

    public long getLongFromByte(byte byteNumber){
        long longNumber =byteNumber;
        return longNumber;
    }

    public char[] getCharacterFromString(String name){
        return name.toCharArray();
    }

    public String getReplacedString(String name,String oldCharacter,String newCharacter){
        return name.replace(oldCharacter,newCharacter);
    }

    public int getIndexOf(String name,char findIndexChar){
        return name.indexOf(findIndexChar);
    }

    public String getNameUsingSubString(String name,int beginIndex,int endingIndex){
        return name.substring(beginIndex,endingIndex);
    }

    public int getIndex(String[] nameArray, String findString) {
        int index;
        for ( index = 0; index < nameArray.length; index++) {
            if (nameArray[index].equals(findString)) {
                break;
            }
        }
        return index;
    }
}