package com.example.manifestloader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manifestloader.R;
import com.example.manifestloader.db.table.TLookup;
import com.example.manifestloader.models.OuterObject;
import com.example.manifestloader.tools.JsonTool;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            OuterObject outerObject = JsonTool.parseJson(this);

            TLookup tLookup = new TLookup();
            tLookup.setContent(outerObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
