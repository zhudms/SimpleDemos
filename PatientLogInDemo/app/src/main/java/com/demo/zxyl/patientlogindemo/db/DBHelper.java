package com.demo.zxyl.patientlogindemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.demo.zxyl.patientlogindemo.urils.SPUtil;
import com.demo.zxyl.patientlogindemo.urils.VALUES;


/**
 * Created by TANG on 2016/3/12.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static int CURRECTVERSION = 1;

    //数据库字段
    public static final String USERINFO = "userinfo";//患者表名
    public static final String ID = "id";
    public static final String PATIENT = "patient";

    //表示是否已经创建过表
    private boolean hasCreateTable = false;
    public static final String HAS_BUILD_DATABASE = "HAS_CREATE";
    private Context context;

    public DBHelper(Context context) {
        super(context, "zxylp.db", null, CURRECTVERSION);
        this.context = context;
        hasCreateTable = (Boolean) SPUtil.get(context, HAS_BUILD_DATABASE, false);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //用户表
        /**
         id  流水号
         UUID 用户编码
         LOGIN_NAME 登陆账号
         PASSWORD 密码
         USERNAME 真实姓名
         ORG_NAME 所属机构名称
         ORG_CODE 机构代码
         DEPT_NAME 科室
         DEPT_CODE 科室代码
         WARD_NAME 病区
         WARD_CODE 病区代码
         HEADPATH 头像路径
         */
        if (!hasCreateTable){
            db.execSQL("create table "+USERINFO+
                    "(id integer primary key autoincrement," +
                    "patient text"  + VALUES.BRACKETS_RIGHT);
            SPUtil.put(context,HAS_BUILD_DATABASE,true);
        }

    }


//    public static final String IFSHAKE = "ifShake";
//    public static final String FROMH = "fromH";
//    public static final String FROMM = "fromM";
//    public static final String FROMINTERVAL = "frominterval";
//    public static final String ENDH = "endH";
//    public static final String ENDM = "endM";
//    public static final String ENDINTERVAL = "endinterval";
//
//
//public static final String RES_ID = "RES_ID";
//public static final String TYPE = "TYPE";
//public static final String GUID = "GUID";
//public static final String TITLE = "TITLE";
//public static final String VIDEO_PATH = "VIDEO_PATH";
//public static final String RES_DESC = "RES_DESC";
//public static final String IS_COLLECT = "IS_COLLECT";
//public static final String floderID = "floderID";
//
//
//public static final String NAME = "name";
//public static final String TIME = "time";
//public static final String FLODER_ID = "id";



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
