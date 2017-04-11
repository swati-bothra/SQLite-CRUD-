package com.example.android.sqlite.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.android.sqlite.Data.tourContract.tourEntry;

import static android.R.attr.version;

/**
 * Created by Owner on 4/2/2017.
 */

public class tourDbHelper extends SQLiteOpenHelper {

    public String CREATE_TABLE = "CREATE TABLE "+ tourEntry.TABLE_NAME + "(" + tourEntry.NAME + " TEXT," + tourEntry.DATE + " TEXT);";

    public static final int DATABASE_VERSION = 9;

    public tourDbHelper(Context context) {
        super(context,tourEntry.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.v("cdscecdef","created TABBLE");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void insert(tourDbHelper tdb,String name, String date){

        SQLiteDatabase db = tdb.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(tourEntry.NAME,name);
        cv.put(tourEntry.DATE,date);
        Long id = db.insert(tourEntry.TABLE_NAME,null,cv);
        Log.v("111111111111111111111",id.toString());
    }
    public Cursor select(tourDbHelper tdb){
        SQLiteDatabase db = tdb.getReadableDatabase();
        String[] projection = {tourEntry.NAME,tourEntry.DATE};
        Cursor c=  db.query(tourEntry.TABLE_NAME,projection,null,null,null,null,null);
        return c;
    }


    public void delete(tourDbHelper tdb,String name){
        SQLiteDatabase db = tdb.getWritableDatabase();
        String selection = tourEntry.NAME + "= ?" ;
        String[] args = {name};
        db.delete(tourEntry.TABLE_NAME,selection,args);
    }
    public void update(tourDbHelper tdb, String oName , String nName){

        SQLiteDatabase db = tdb.getWritableDatabase();
        String selection = tourEntry.NAME + " = ?";
        String[] args = {oName};
        ContentValues v = new ContentValues();
        v.put("NAME",nName);
        db.update(tourEntry.TABLE_NAME,v,selection,args);
    }
}
