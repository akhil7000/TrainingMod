package com.training.assignments;

import java.util.ArrayList;

public class Assignment11 {
    public ArrayList getSportExceptAtIndex(ArrayList<String> sport, int index) {
        ArrayList<String> newSportArray = new ArrayList<>();
        for (int i = 0; i < sport.size(); i++)
            if (i != index) {
                newSportArray.add(sport.get(i));
            }
        return newSportArray;
    }
}