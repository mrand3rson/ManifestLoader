package com.example.manifestloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.manifestloader.db.table.TLookup;

public class Database extends SQLiteOpenHelper {

    private final String LOG_TAG = getClass().getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "name.db"; //TODO: rename database
    private static Database sInstance;
    public static final String TLOOKUP = "TLookup";


    private Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized Database getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Database(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String TBUILD_LOOKUP = "CREATE TABLE " + TLOOKUP + "("
                + TLookup.PK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + FK_STUDYID + " INTEGER NULL, "
                + TLookup.IHOSTNAME + " TEXT NULL, "
                + TLookup.IKIND + " TEXT NOT NULL, "
                + TLookup.ILIST + " TEXT NULL, "
                + TLookup.ICREATED_AT + " DATETIME NULL, "
                + TLookup.IUPDATED_AT + " DATETIME NULL"
                //A.S. TODO: add foreign key relationship
//                "FOREIGN KEY(" + FK_STUDYID + ") " + "REFERENCES " + T%%% + "(" + PK%%% + ")"
                + ");";

        db.execSQL(TBUILD_LOOKUP);

        Log.d(LOG_TAG, "onCreate end");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(LOG_TAG, "onUpgrade end");
    }
}
