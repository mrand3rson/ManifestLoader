package com.example.manifestloader.tools;

import android.content.Context;
import android.widget.Toast;

import com.example.manifestloader.R;
import com.example.manifestloader.models.OuterObject;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

public class JsonTool {

    public static OuterObject parseJson(Context context) throws IOException {
        Gson gson = new Gson();
        String jsonString = getJsonString(context, R.raw.manifest);
        OuterObject lookup = gson.fromJson(jsonString, OuterObject.class);

        //debug outputs TODO: remove
        Toast.makeText(context, lookup.getWhitelist().get(0).getHostname(), Toast.LENGTH_LONG).show();
        Toast.makeText(context, lookup.getBlacklist().get(0).getHostname(), Toast.LENGTH_LONG).show();
        Toast.makeText(context, lookup.getName(), Toast.LENGTH_LONG).show();

        return lookup;
    }

    private static String getJsonString(Context context, int raw) throws IOException {
        InputStream is = context.getResources().openRawResource(raw);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }
}
