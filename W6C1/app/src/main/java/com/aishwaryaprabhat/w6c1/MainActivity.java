package com.aishwaryaprabhat.w6c1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends AppCompatActivity {
    public String filename = "sample";
    public FileOutputStream fout;
    public File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button savebtn = (Button)findViewById(R.id.save);
        Button readbtn = (Button)findViewById(R.id.read);
        final EditText input_text = (EditText)findViewById(R.id.edit);
        savebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"File Saved",Toast.LENGTH_LONG).show();
                        file = new File(Environment.getExternalStorageDirectory(),filename);

                        try {
                            fout = new FileOutputStream(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        try {
                            fout.write(input_text.getText().toString().getBytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );
        readbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int length = (int) file.length();
                        byte[] bytes = new byte[length];

                        try {
                            FileInputStream fi = new FileInputStream(file);
                            fi.read(bytes);

                            String text = new String(bytes);
                            Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );

    }
}
