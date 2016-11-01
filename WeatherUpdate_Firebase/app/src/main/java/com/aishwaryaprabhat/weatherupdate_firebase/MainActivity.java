package com.aishwaryaprabhat.weatherupdate_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final TextView condition = (TextView)findViewById(R.id.textViewCondition);
        Button sunny = (Button)findViewById(R.id.buttonSunny);
        Button foggy = (Button)findViewById(R.id.buttonFoggy);
        final Firebase myurl = new Firebase("https://crowdweather-2c742.firebaseio.com/weather");

        myurl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                condition.setText(data);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        sunny.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        myurl.setValue("Sunnyaf");
                    }
                }

        );
        foggy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myurl.setValue("FOggyaf");
                    }
                }
        );

    }
}
