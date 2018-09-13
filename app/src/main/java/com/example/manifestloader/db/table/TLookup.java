package com.example.manifestloader.db.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.manifestloader.ManifestLoaderApplication;
import com.example.manifestloader.models.Lookup;
import com.example.manifestloader.models.OuterObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.manifestloader.db.Database.TLOOKUP;

public class TLookup {

    public static final String PK_ID = "id";
    public static final String IHOSTNAME = "hostname";
    public static final String IKIND = "kind";
    public static final String ILIST = "list";
    public static final String ICREATED_AT = "created_at";
    public static final String IUPDATED_AT = "updated_at";
    public static final String FK_STUDYID = "study_id";


    public static List<Lookup> getContent() {
        SQLiteDatabase db = ManifestLoaderApplication.getDatabase().getWritableDatabase();
        try (Cursor c = db.query(TLOOKUP, null, null, null, null, null, null)) {
            if (c.getCount() > 0) {
                List<Lookup> results = new ArrayList<>();
                Lookup entry;
                int idIndex = c.getColumnIndex(PK_ID);
                int hostnameIndex = c.getColumnIndex(IHOSTNAME);
                int kindIndex = c.getColumnIndex(IKIND);
                int listTypeIndex = c.getColumnIndex(ILIST);
                int createdIndex = c.getColumnIndex(ICREATED_AT);
                int updatedIndex = c.getColumnIndex(IUPDATED_AT);

                while (c.moveToNext()) {
                    entry = new Lookup();
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
        }
        return null;
    }

    public void setContent(OuterObject object) {
        SQLiteDatabase db = ManifestLoaderApplication.getDatabase().getWritableDatabase();

        for (Lookup entry : object.getBlacklist()) {
            TLookup.insertLookupEntry(db, entry);
        }
        for (Lookup entry : object.getWhitelist()) {
            TLookup.insertLookupEntry(db, entry);
        }
    }

    public static void insertLookupEntry(SQLiteDatabase db, Lookup entry) {
        db.execSQL("INSERT INTO " + TLOOKUP
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
}
