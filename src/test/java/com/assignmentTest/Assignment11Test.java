package com.assignmentTest;

import com.assignment.Assignment11;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Assignment11Test {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testSportWithoutIndexAt(){
        ArrayList<String> sportNamesArray=new ArrayList<>();
        sportNamesArray.addAll(Arrays.asList("Tennis", "Volleyball","Cricket","Cycling","Swimming","Badminton"));
        int index =3;
        Assignment11 assignment11=new Assignment11();
        ArrayList newSportNamesArray = assignment11.getSportExceptAtIndex(sportNamesArray,index);
        Iterator iterator = newSportNamesArray.iterator();

        while(iterator.hasNext()){
            logger.info(iterator.next().toString());
        }

        /**
         * Assertion to check if correct array has been retrieved
         */
        ArrayList <String>sportNamesVerificationArray=new ArrayList<>();
        for(int i=0;i<sportNamesArray.size();i++){
            if (i!=index)
            {
                sportNamesVerificationArray.add(sportNamesArray.get(i));
            }
        }
        System.out.println(sportNamesVerificationArray);

    }
}

