package com.niit.support;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GeneralSupport {
    private static GeneralSupport ourInstance = new GeneralSupport();

    public static GeneralSupport getInstance() {
        return ourInstance;
    }

    private GeneralSupport() {
    }
    public static Timestamp getTimeStamp() {
        LocalDateTime ldt = LocalDateTime.now();
        Timestamp ts = Timestamp.valueOf(ldt);
        return ts;
    }



}
