package com.aishwaryaprabhat.myandroidapplicationcheckoff1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("My Android Application");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }
}
