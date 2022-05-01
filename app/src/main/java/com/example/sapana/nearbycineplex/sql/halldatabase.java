package com.example.sapana.nearbycineplex.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sapana.nearbycineplex.hall.HallScheme;

public class halldatabase extends SQLiteOpenHelper {


    public static String DATABASE = "halldatabase.db";
    public static String TABLE ="halltable1";
    public static String TABLE_1 ="halltable2";
    public static String TABLE_2 ="halltable3";
    public static String TABLE_3 ="halltable4";
    public static String TABLE_PAY ="paytable";
    public static String ID="seat_id";
    public static String ID_1="seat_id";
    public static String ID_2="seat_id";
    public static String ID_3="seat_id";
    public static String ID_PAY="seat_id";
    public static String STATUS="seat_status";
    public static String STATUS_1="seat_status";
    public static String STATUS_2="seat_status";
    public static String STATUS_3="seat_status";
    public static String STATUS_PAY="seat_status";
    String br,br2,br3,br4,pr;

    public halldatabase(Context context) {
        super(context, DATABASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";
        br = "CREATE TABLE "+TABLE+"("+ID+ " INTEGER, "+STATUS+ " Text);";
        br2= "CREATE TABLE "+TABLE_1+"("+ID_1+ " INTEGER, "+STATUS_1+ " Text);";
        br3= "CREATE TABLE "+TABLE_2+"("+ID_2+ " INTEGER, "+STATUS_2+ " Text);";
        br4= "CREATE TABLE "+TABLE_3+"("+ID_3+ " INTEGER, "+STATUS_3+ " Text);";
        pr= "CREATE TABLE "+TABLE_PAY+"("+ID_PAY+ " INTEGER, "+STATUS_PAY+ " Text);";
        db.execSQL(br);
        db.execSQL(br2);
        db.execSQL(br3);
        db.execSQL(br4);
        db.execSQL(pr);
        Log.d("dit","table creation successful");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_1+" ;");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_2+" ;");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_3+" ;");
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PAY+" ;");
    }


    public void insertdata(Integer id, String seat_status){   //SchemeBasic
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(STATUS, seat_status);
        db.insert(TABLE,null,contentValues);
    }

    public void insertdata1(Integer id, String seat_status){  //SchemeBasic2
        System.out.print("Hello "+br2);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID_1, id);
        contentValues.put(STATUS_1, seat_status);
        db.insert(TABLE_1,null,contentValues);
    }
    public void insertdata2(Integer id, String seat_status){   //SchemewithScene
        System.out.print("Hello "+br3);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID_2, id);
        contentValues.put(STATUS_2, seat_status);
        db.insert(TABLE_2,null,contentValues);
    }
    public void insertdata3(Integer id, String seat_status){  // //SchemewithScene2
        System.out.print("Hello "+br4);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID_3, id);
        contentValues.put(STATUS_3, seat_status);
        db.insert(TABLE_3,null,contentValues);
    }
    public void insertdatapay(Integer id, String seat_status){
        System.out.print("Hello "+pr);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(ID_PAY, id);
        contentValues.put(STATUS_PAY, seat_status);
        db.insert(TABLE_PAY,null,contentValues);
    }
    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE,null);
        return  res;
    }
    public Cursor getalldata1()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_1,null);
        return  res;
    }
    public Cursor getalldata2()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_2,null);
        return  res;
    }
    public Cursor getalldata3()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_3,null);
        return  res;
    }
    public Cursor getalldatapay()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TABLE_PAY,null);
        return  res;
    }

   }