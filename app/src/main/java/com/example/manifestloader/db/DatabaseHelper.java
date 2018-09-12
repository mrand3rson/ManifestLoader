package com.example.manifestloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final String LOG_TAG = getClass().getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "name.db";
    private static DatabaseHelper sInstance;

    public static final String PK_ID = "id";

    public static final String IHOSTNAME = "hostname";
    public static final String IKIND = "kind";
    public static final String ILIST = "list";
    public static final String ICREATED_AT = "created_at";
    public static final String IUPDATED_AT = "updated_at";

    public static final String FK_STUDYID = "study_id";

    public static final String TLOOKUP = "TLookup";


    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String TBUILD_LOOKUP = "CREATE TABLE " + TLOOKUP + "("
                + PK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + FK_STUDYID + " INTEGER NULL, "
                + IHOSTNAME + " TEXT NULL, "
                + IKIND + " TEXT NOT NULL, "
                + ILIST + " TEXT NULL, "
                + ICREATED_AT + " DATETIME NULL, "
                + IUPDATED_AT + " DATETIME NULL"
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
