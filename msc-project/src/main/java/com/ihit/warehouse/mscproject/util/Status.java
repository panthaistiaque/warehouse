package com.ihit.warehouse.mscproject.util;

/**
 * Created by User on 3/13/2021.
 */
public class Status {
    public static String INITIATED = "Initiated";
    public static String FROWARD = "Froward";
    public static String OPEN = "Open";
    public static String PROCESSING ="Processing";
    public static String SEND = "Send";
    public static String APPROVED = "Approved";
    public class Notification{
        public static final String  ERROR_404 = "Try to reach on a invalid URL";
        public static final String  ERROR_403 = "User try to reach unauthorized URL";
        public static final String  ERROR_500 = "Unexpected error";
    }public class NOTIFICATION_TYPE{
        public static final String  USER_NOTIFICATION = "NOTI";
        public static final String  SYS_NOTIFICATION = "SYS_NOTI";
    }
}
