package com.assignmentTest;

import com.assignment.Assignment11;
import org.junit.jupiter.api.Assertions;
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
        ArrayList<String> sportNamesList=new ArrayList<>();
        sportNamesList.addAll(Arrays.asList("Tennis", "Volleyball","Cricket","Cycling","Swimming","Badminton"));
        int index =3;
        Assignment11 assignment11=new Assignment11();

        ArrayList newSportNamesList = assignment11.getSportExceptAtIndex(sportNamesList,index);
        Iterator iterator = newSportNamesList.iterator();

        while(iterator.hasNext()){
            logger.info(iterator.next().toString());
        }

        /**
         * Assertion to check if correct array has been retrieved
         */
        ArrayList <String>sportNamesVerificationList=new ArrayList<>();
        sportNamesVerificationList = sportNamesList;
        sportNamesVerificationList.remove(index);

        Assertions.assertArrayEquals(newSportNamesList.toArray(),sportNamesVerificationList.toArray(),
                "Arraylists don't match");

    }
}

