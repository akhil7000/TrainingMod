package com.training.assignments;

import java.util.ArrayList;
import java.util.List;

public class Assignment11 {
    public List<String> getSportsName() {
        List<String> sportsname = new ArrayList<>();
        sportsname.add("Cricket");
        sportsname.add("Hockey");
        sportsname.add("Football");
        sportsname.add("Tennis");
        sportsname.add("baseball");
        sportsname.add("Lawn tennis");

        for (int index = 0; index < sportsname.size(); index++) {
            if (index == 3) {
                sportsname.remove(index);
            }
        }
        return sportsname;
    }

}


