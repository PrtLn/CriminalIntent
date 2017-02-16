package com.prt.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.prt.criminalintent.database.CrimeBaseHelper;
import com.prt.criminalintent.database.CrimeDbSchema;
import com.prt.criminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by L.Pikalova on 2/10/2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        // mAppContext = context;
        // opening the SQLiteDatabase
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext)
                .getWritableDatabase();
    }

    public void addCrime(Crime crime) {
        ContentValues values = getContentValues(crime);

        mDatabase.insert(CrimeTable.NAME, null, values);
    }

    public void deleteCrime(Crime crime) {
//        mCrimes.remove(crime);
    }

    public List<Crime> getCrimes() {
        return new ArrayList<>();
    }

    public Crime getCrime(UUID id) {
        return null;
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeTable.NAME, values,
                CrimeTable.Columns.UUID + " = ?",
                new String[] { uuidString });
    }

    private static ContentValues getContentValues(Crime crime) {
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Columns.UUID, crime.getId().toString());
        values.put(CrimeTable.Columns.TITLE, crime.getTitle());
        values.put(CrimeTable.Columns.DATE, crime.getDate().getTime());
        values.put(CrimeTable.Columns.SOLVED, crime.isSolved() ? 1 : 0);

        return values;
    }

    private Cursor queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
               CrimeTable.NAME,
                null, // Columns - null choose all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return cursor;
    }
}
