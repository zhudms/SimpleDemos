package com.demo.zxyl.patientlogindemo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.demo.zxyl.patientlogindemo.beans.BedMessageB;
import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.urils.LogUtil;
import com.demo.zxyl.patientlogindemo.urils.VALUES;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by TANG on 2016/6/10.
 * Patient
 */
public class DBService {


    private final String TAG = Class.class.getSimpleName();

    private DBHelper mHelper = null;

    public static DBService mDbService;

    public static DBService getInstance(Context context) {
        if (mDbService == null) {
            synchronized (DBService.class) {
                mDbService = new DBService(context);
            }
        }
        return mDbService;
    }

    public DBService(Context context) {

        if (mHelper == null) {
            mHelper = new DBHelper(context);
        }

    }


    public void savePatient(PatientB mPatient) {

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(mPatient);
            objectOutputStream.flush();
            byte data[] = arrayOutputStream.toByteArray();
            objectOutputStream.close();
            arrayOutputStream.close();
            SQLiteDatabase database = mHelper.getWritableDatabase();
            database.execSQL("insert into " + DBHelper.USERINFO +
                    VALUES.BRACKETS_LEFT + DBHelper.PATIENT + VALUES.BRACKETS_RIGHT +
                    "values(?)", new Object[]{data});
            database.close();
        } catch (Exception e) {
            LogUtil.e(VALUES.TAG_FILTER, TAG + e.toString());
            e.printStackTrace();
        }

    }


    public PatientB getPatient() {
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        PatientB patientMessage = null;
        Cursor cursor = mDb.rawQuery("select * from " + DBHelper.USERINFO, null);
        if (cursor != null&&cursor.moveToNext()) {
            byte data[] = cursor.getBlob(cursor.getColumnIndex( DBHelper.PATIENT));
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(data);
            try {
                ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
                patientMessage = (PatientB) inputStream.readObject();

                inputStream.close();
                arrayInputStream.close();
                return patientMessage;
            } catch (Exception e) {
                LogUtil.e(VALUES.TAG_FILTER, TAG + e);
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return patientMessage;
    }

    public  void delLocalPatient(){
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        mDb.execSQL("delete from "+DBHelper.USERINFO);
    }

    public void clearTableDatas(){
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        mDb.execSQL("delete from "+DBHelper.USERINFO);
    }
}
