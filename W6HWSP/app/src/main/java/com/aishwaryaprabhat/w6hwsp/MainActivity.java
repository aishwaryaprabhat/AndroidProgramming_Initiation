package com.aishwaryaprabhat.w6hwsp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String name_parent;
    String pillar_str;
    String s;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onStart(){
        super.onStart();

        final Button save = (Button)findViewById(R.id.buttonSave);
        final EditText name = (EditText)findViewById(R.id.editTextName);
        final EditText pillar = (EditText)findViewById(R.id.editTextPillar);
        final Firebase myurl = new Firebase("https://studentparticulars.firebaseio.com/Person");
        final TextView studentnameview = (TextView) findViewById(R.id.textViewStudentName);
        RadioButton gotosearch = (RadioButton)findViewById(R.id.radioButtonGoToSearch);
        gotosearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),Search.class);
                        startActivity(intent);
                    }
                }
        );

        System.out.println(name_parent);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        name_parent = name.getText().toString();
                        pillar_str = pillar.getText().toString();
                        myurl.child(name_parent);
                        myurl.child(name_parent).child("name").setValue(name_parent);
                        myurl.child(name_parent).child("pillar").setValue(pillar_str);

                    }
                }
        );
        myurl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> list = new ArrayList<String>();
                for(DataSnapshot child: dataSnapshot.getChildren()){
                    String data = child.getKey();
                    list.add(data);

                }
                String todisplay ="Names\n";
                for(String item: list){
                    todisplay = todisplay+"\n"+item;
                }
                studentnameview.setText(todisplay);



            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


    }
}
