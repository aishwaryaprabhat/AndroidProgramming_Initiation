package com.aishwaryaprabhat.aishfirstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Aish's message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, ":onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, ":onStart");
    }
}
