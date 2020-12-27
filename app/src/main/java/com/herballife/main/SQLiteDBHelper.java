package com.herballife.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by kamal on 5/8/17.
 */

public class SQLiteDBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "data2.sqlite";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase getDb(){
        return getWritableDatabase();
    }
}
