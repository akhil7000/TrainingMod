package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Assignment11Test {

    Assignment11 assignment11=new Assignment11();

    @Test
        public void testGetSportsName(){
        List<String> sportsname = new ArrayList<>();
        sportsname.add("Cricket");
        sportsname.add("Hockey");
        sportsname.add("Football");
        sportsname.add("baseball");
        sportsname.add("Lawn tennis");
        Assertions.assertEquals(sportsname,assignment11.getSportsName());
        }
    }
