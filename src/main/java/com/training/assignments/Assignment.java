package com.training.assignments;

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
        int index;
        char[] characterArray=name.toCharArray();
        char[] characters = new char[name.length()];
        for(index=0;index<characterArray.length;index++){
            characters[index] = characterArray[index];
        }
        return characters;
    }

    public String getReplacedString(String name,String oldCharacter,String newCharacter){
        String replacedString=name.replace(oldCharacter,newCharacter);
        return replacedString;
    }

    public int getIndexOf(String name,char findIndexChar){
        int index=name.indexOf(findIndexChar);
        return index;
    }

    public String getNameUsingSubString(String name,int beginIndex,int endingIndex){
        String getName=name.substring(beginIndex,endingIndex);
        return getName;
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