package com.example.manifestloader;

import android.app.Application;

import com.example.manifestloader.db.Database;

public class ManifestLoaderApplication extends Application {

    public static Database getDatabase() {
        return database;
    }
    private static Database database;


    @Override
    public void onCreate() {
        super.onCreate();

        if (database == null) {
            database = Database.getInstance(this);
        }
    }
}
