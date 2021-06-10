package com.example.sghospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HospitalData extends SQLiteOpenHelper {

    public static final String HOSPITAL_TABLE = "HOSPITAL_TABLE";
    public static final String COL_HOSPITAL_NAME = "HOSPITAL_NAME";
    public static final String COL_HOSPITAL_AGE = "HOSPITAL_AGE";
    public static final String COL_HOSPITAL_ADDRESS = "HOSPITAL_ADDRESS";
    public static final String COL_HOSPITAL_PHONE = "HOSPITAL_PHONE";
    public static final String COL_HOSPITAL_EMAIL = "HOSPITAL_EMAIL";

    public HospitalData(@Nullable Context context) {
        super(context, "patient.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + HOSPITAL_TABLE + "(" + COL_HOSPITAL_NAME + " TEXT," + COL_HOSPITAL_AGE + " TEXT," + COL_HOSPITAL_ADDRESS + " TEXT," + COL_HOSPITAL_PHONE + " TEXT PRIMARY KEY," + COL_HOSPITAL_EMAIL + " TEXT" + ")";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+HOSPITAL_TABLE);
        onCreate(db);
    }

    public boolean addOne(Models models) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_HOSPITAL_NAME, models.getName());
        cv.put(COL_HOSPITAL_AGE, models.getAge());
        cv.put(COL_HOSPITAL_ADDRESS, models.getAddress());
        cv.put(COL_HOSPITAL_PHONE, models.getPhone());
        cv.put(COL_HOSPITAL_EMAIL, models.getEmail());
        long insert;
        insert = db.insert(HOSPITAL_TABLE, null, cv);
        return insert != -1;

    }

    public List<Models> getEveryone() {
        List<Models> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + HOSPITAL_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String patientName = cursor.getString(0);
                String patientAge = cursor.getString(1);
                String patientAddress = cursor.getString(2);
                String patientPhone = cursor.getString(3);
                String patientEmail = cursor.getString(4);
                Models models = new Models(patientName, patientAge, patientAddress, patientPhone, patientEmail);
                 returnList.add(models);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }
}

