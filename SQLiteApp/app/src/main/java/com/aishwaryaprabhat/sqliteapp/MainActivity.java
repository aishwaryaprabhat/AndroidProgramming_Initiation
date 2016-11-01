package com.aishwaryaprabhat.sqliteapp;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;



public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }



    public void validate(View v){

        String password = ((EditText) findViewById(R.id.password)).getText().toString();

        if (password.equals("java")){

            Intent intent = new Intent(this, SQL_entry.class);

            startActivity(intent);

        }

    }

}