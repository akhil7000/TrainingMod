package com.training.utilities;

import java.util.Date;

public class GetUniqueMailId {
    public static String getUniqueMailId() {
        Date date = new Date();
        Long luid = (Long) date.getTime();
        String mailid = "test"+luid.toString()+"@api.com";
        return mailid;
    }
}