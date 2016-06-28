package com.devkito.log4asample;

import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.devkito.log4a.Sys;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.EOFException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sys.mode(Sys.LEVEL.None);
        Sys.log("OnCreate");
        try {
            Sys.log(new JSONObject().put("XXXX", "dfsagjhgkfdsafhja"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Sys.log(new IOException());
        Sys.log(new NumberFormatException());

        //Sys.logD("OnCreate");
        //Sys.logD("OnCreate", new NumberFormatException());

        //Sys.logE("OnCreate");
        //Sys.logE("OnCreate", new NumberFormatException());

        //Sys.logI("OnCreate");
        //Sys.logI("OnCreate", new NumberFormatException());

        //Sys.logV("OnCreate");
        //Sys.logV("OnCreate", new NumberFormatException());

        Sys.logW("OnCreate");
        //Sys.logW("OnCreate", new NumberFormatException());
    }
}
