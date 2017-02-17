package com.prt.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.prt.criminalintent.Crime;
import com.prt.criminalintent.database.CrimeDbSchema.CrimeTable;

/**
 * Created by L.Pikalova on 2/16/2017.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating a data base table
        db.execSQL("create table " + CrimeTable.NAME +
            "(" + "_id integer primary key autoincrement, " +
            CrimeTable.Columns.UUID + ", " +
            CrimeTable.Columns.TITLE + ", " +
            CrimeTable.Columns.DATE + ", " +
            CrimeTable.Columns.SOLVED + ", " +
            CrimeTable.Columns.SUSPECT +
            ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
