package com.example.manifestloader.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manifestloader.models.OuterObject;
import com.example.manifestloader.models.TLookup;

import java.util.ArrayList;
import java.util.List;

public class DatabaseController {
    public static void insertLookup(DatabaseHelper databaseHelper, OuterObject lookup) {

//        + PK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
//        + IHOSTNAME + " TEXT NULL, "
//        + IKIND + " TEXT NOT NULL, "
//        + ILIST + " TEXT NULL, "
//        + ICREATED_AT + " DATETIME NULL, "
//        + IUPDATED_AT + " DATETIME NULL"
    }

    public static void insertListEntry(DatabaseHelper databaseHelper, TLookup entry) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        db.execSQL("INSERT INTO " + DatabaseHelper.TLOOKUP
                + " VALUES " + "("
                + entry.id + ", "
                + "'" + entry.getHostname() + "', "
                + "'" + entry.getKind() + "', "
                + "'" + entry.getListType() + "', "
                + "'" + entry.getCreatedAt() + "', "
                + "'" + entry.getUpdatedAt() + "'"
                + ");"
        );
    }

    public static List<TLookup> readListEntries(DatabaseHelper databaseHelper) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor c = db.query(DatabaseHelper.TLOOKUP, null, null, null, null, null, null);
        if (c.getCount() > 0) {
            List<TLookup> results = new ArrayList<>();
            TLookup entry;
            int idIndex = c.getColumnIndex(DatabaseHelper.PK_ID);
            int hostnameIndex = c.getColumnIndex(DatabaseHelper.IHOSTNAME);
            int kindIndex = c.getColumnIndex(DatabaseHelper.IKIND);
            int listTypeIndex = c.getColumnIndex(DatabaseHelper.ILIST);
            int createdIndex = c.getColumnIndex(DatabaseHelper.ICREATED_AT);
            int updatedIndex = c.getColumnIndex(DatabaseHelper.IUPDATED_AT);

            while (c.moveToNext()) {
                entry = new TLookup();
                entry.id = c.getLong(idIndex);
                entry.setHostname(c.getString(hostnameIndex));
                entry.setKind(c.getString(kindIndex));
                entry.setListType(c.getString(listTypeIndex));
                entry.setCreatedAt(c.getString(createdIndex));
                entry.setUpdatedAt(c.getString(updatedIndex));
                results.add(entry);
            }
            return results;
        }

        return null;
    }
}
