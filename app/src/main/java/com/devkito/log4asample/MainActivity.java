package com.devkito.log4asample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.devkito.log4a.Sys;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sys.mode(Sys.LEVEL.None);
        Sys.log("OnCreate");
    }
}
