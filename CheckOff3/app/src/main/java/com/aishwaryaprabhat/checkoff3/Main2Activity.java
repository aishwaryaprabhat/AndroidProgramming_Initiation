package com.aishwaryaprabhat.checkoff3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Lenovo on 10/30/2016.
 */
public class Main2Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button hi_button = (Button)findViewById(R.id.hi_button);
        hi_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext()
                        ,yo.class);
                        startActivity(intent);
                    }
                }
        );
        RadioButton radio = (RadioButton)findViewById(R.id.radioButton);
        radio.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(getApplicationContext(),)
                        Toast.makeText(Main2Activity.this,"Radio button clicked",Toast.LENGTH_LONG).show();
                    }
                }
        );
        Button email_button = (Button)findViewById(R.id.email_button);
        email_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),EmailActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
