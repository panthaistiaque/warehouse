package com.ihit.warehouse.mscproject.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 8/15/2021.
 */
public class DateUtil {
    public static String currentDateTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = df.format(date);
        return currentDate;
    }

}
