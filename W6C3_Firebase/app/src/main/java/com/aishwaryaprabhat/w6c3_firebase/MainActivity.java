package com.aishwaryaprabhat.w6c3_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView message = (TextView)findViewById(R.id.textViewStatus);
        final Firebase myurl = new Firebase("https://academicignition.firebaseio.com/message");
        myurl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                message.setText(text);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        myurl.setValue("Got connected successfully!");

    }
}
