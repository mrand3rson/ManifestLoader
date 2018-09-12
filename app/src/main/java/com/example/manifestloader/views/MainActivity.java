package com.example.manifestloader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.manifestloader.R;
import com.example.manifestloader.db.DatabaseController;
import com.example.manifestloader.db.DatabaseHelper;
import com.example.manifestloader.models.OuterObject;
import com.example.manifestloader.models.TLookup;
import com.example.manifestloader.tools.JsonTool;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = DatabaseHelper.getInstance(this);

        try {
            OuterObject outerObject = JsonTool.parseJson(this);
            fillDB(outerObject, db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillDB(OuterObject lookup, DatabaseHelper dbHelper) {
        for (TLookup entry : lookup.getBlacklist()) {
            DatabaseController.insertListEntry(dbHelper, entry);
        }
        for (TLookup entry : lookup.getWhitelist()) {
            DatabaseController.insertListEntry(dbHelper, entry);
        }

        List<TLookup> records = DatabaseController.readListEntries(dbHelper);
        if (records != null) {
            for (TLookup entry: records) {
                Toast.makeText(this, entry.getHostname(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "EMPTY", Toast.LENGTH_SHORT).show();
        }
    }
}
