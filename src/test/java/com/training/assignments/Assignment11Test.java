package com.training.assignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class Assignment11Test {

    @Test
        public void testGetSportsName(){
        List<String> sportsname = new ArrayList<>();
        sportsname.add("Cricket");
        sportsname.add("Hockey");
        sportsname.add("Football");
        sportsname.add("baseball");
        sportsname.add("Lawn tennis");
        Assertions.assertEquals(sportsname,new Assignment11().getSportsName(),"Incorrect sportsname");
        }
    }
