package com.assignmentTest;

import com.assignment.Assignment10;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class Assignment10Test {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void printodd() {
        Assignment10 assignment10 = new Assignment10();

        ArrayList abc = assignment10.getOddNumber(10, 20);
        Iterator itr = abc.iterator();
        while (itr.hasNext()) {
            logger.info((itr.next()).toString());
        }
    }
}
