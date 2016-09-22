package com.demo.zl.mytabdemo;

/**
 * Created by TANG on 2016/4/2.
 */
public class VALUES {
    public static final long HTTP_CONNECT_TIMEOUT = 50;
    public static final long HTTP_READ_TIMEOUT = 200;


    public static final int GESTURE_SIZE = 3;

//    public static  final int NET_SUCCESS=1;
//    public static  final int NET_FAIL=1;

    public static String TAG_FILTER="asd";


    public static String PATIENTBEAN_MESSAGE="patient";


    public static final int NET_STATE_ENABLE=0;
    public static final int NET_STATE_ABLE=1;

    public final static String LINKER ="-";
    public final static String HOUR_LINKER =":";

    public final static String STRING_YEAR ="年";
    public final static String STRING_MONTH ="月";
    public final static String STRING_DAY="日";

    public final static String BRACKETS_LEFT ="(";
    public final static String BRACKETS_RIGHT =")";


    public final static int SUCCESS = 1;
    public final static int FAILED = -1;
    public final static String NULL = "-2";//网络请求用

    public static final int NORESOURCE=-1;
    public static final int LISTDEFAULT_SIZE = 5;
    public static final int PAGE_SIZE = 10;
    public static final int PAGE_SIZEMORE = 20;
    public static final int PAGE_START = 1;



    public static  String PATIENT_ORGCODE ="";
    public static  String PATIENT_BEDSNO ="";

    public static final String BASE_URL = "base_url";
    public static final String LOGIN_AUTO_NULL = "";


    public static final int REQUEST_TYPE_REFUSH=10;
    public static final int REQUEST_TYPE_MORE=11;
//
//
//    public static final int MESSAGE_TYPE_ERROR = -1;
//    public static final int MESSAGE_TYPE_ALL = 0;
//    public static final int MESSAGE_TYPE_NORMAL = 5;
//    public static final int MESSAGE_TYPE_ALLCHECK = 5;
//

    //treeList-type

    public static final int TREELIST_PARENT=0;

    public static final int TREELIST_IMPORTANT= 1;
    /**
     * 我的消息-资源类的推送
     */
    public static final int TREELIST_SOURCE_FLODER = 20;
    public static final int TREELIST_SOURCE_ITEM = 21;
    /**
     * 我的消息-常规
     */
    public static final int TREELIST_MESSNORMAL = 3;
    /**
     * 我的消息-检查检验
     */
    public static final int TREELIST_MESSCHECK = 4;
    /**
     * 我的消息-治疗
     */
    public static final int TREELIST_MESSTREAT= 5;
    /**
     * 我的消息-养护
     */
    public static final int TREELIST_MESSCURING = 6;


    public static final long SHOW_GESTURE_TIME = 60*1000;
}
