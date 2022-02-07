package com.ihit.warehouse.mscproject.util;

/**
 * Created by User on 3/13/2021.
 */
public class Status {
//    public static String INITIATED = "Initiated";
//    public static String FROWARD = "Froward";
//    public static String PROCESSING ="Processing";
//    public static String SEND = "Send";

    public class ORDER_STATUS{
        public static final String  INITIATED = "Initiated";
        public static final String  FROWARD = "Froward";
        public static final String  APPROVED = "Approved";
        public static final String  RECEIVE = "Receive";
    }
    public class SHIPMENT_STATUS{
        public static final String  INITIATED = "Initiated";
        public static final String  FROWARD = "Froward";
        public static final String  APPROVED = "Approved";
        public static final String  RECEIVE = "Receive";
    }
    public class RECEIVE_STATUS{
        public static final String  INITIATED = "Initiated";
        public static final String  FROWARD = "Froward";
        public static final String  APPROVED = "Approved";
        public static final String  RECEIVE = "Receive";
    }
    public class DELIVERY_STATUS{
        public static final String  INITIATED = "Initiated";
        public static final String  COMPLETE = "Competed";
    }

    public class Notification{
        public static final String  ERROR_404 = "Try to reach on a invalid URL";
        public static final String  ERROR_403 = "User try to reach unauthorized URL";
        public static final String  ERROR_500 = "Unexpected error";
    }

    public class NOTIFICATION_MESSAGE{
        public static final String  SUPPLIERS_INSERT = "New Supplier information created";
        public static final String  SUPPLIERS_UPDATE = "Supplier information updated";
        public static final String  SUPPLIERS_DELETE = "Delete Supplier entry";
    }

    public class NOTIFICATION_TYPE{
        public static final String  USER_NOTIFICATION = "NOTI";
        public static final String  SYS_NOTIFICATION = "SYS_NOTI";
    }
}
