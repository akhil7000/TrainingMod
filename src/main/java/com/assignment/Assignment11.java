package com.assignment;

import java.util.ArrayList;

public class Assignment11 {
    public ArrayList getSportExceptAtIndex(ArrayList sport, int index) {
        ArrayList<String> newSportArray = new ArrayList<>();
        for (int i = 0; i < sport.size(); i++)
            if (i != index) {
                newSportArray.add(String.valueOf(sport.get(i)));
            }
        return newSportArray;
    }
}