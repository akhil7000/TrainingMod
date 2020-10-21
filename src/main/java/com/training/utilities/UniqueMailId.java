package com.training.utilities;

import java.util.Date;

/**
 * return :mailid(it returns unique mailid)
 */
public class UniqueMailId {
    public static String getUniqueMailId() {
        Date date = new Date();
        Long luid = (Long) date.getTime();
        String mailid = "test"+luid.toString()+"@api.com";
        return mailid;
    }
}