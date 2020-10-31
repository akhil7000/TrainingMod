package com.training.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operations {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public int searchNameFromArray(String[] strArray, String findString) {
        int i;
        for ( i = 0; i < strArray.length; i++) {
            if (strArray[i].equals(findString)) {
                break;
            }
        }
        return i;
    }
}