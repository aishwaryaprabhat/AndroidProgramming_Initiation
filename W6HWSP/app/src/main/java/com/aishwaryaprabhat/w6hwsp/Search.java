package com.aishwaryaprabhat.w6hwsp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
//import com.google.firebase.database.DatabaseReference;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.snapshot.Node;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final EditText name_search = (EditText)findViewById(R.id.editTextNameToSearch);
        Button search = (Button)findViewById(R.id.buttonSearch);




        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name_to_search = name_search.getText().toString();
                        check_name(name_to_search);
                    }
                }
        );

    }
    String to_display;
    public void check_name(String n){
        final String name_to_search = n;
        final Firebase myurl = new Firebase("https://studentparticulars.firebaseio.com/Person");
//        ArrayList<String> list = new ArrayList<String>();
        final TextView display_details = (TextView)findViewById(R.id.textViewDetails);
        to_display = "No match found";
        myurl.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot child: dataSnapshot.getChildren()){
                            String data = child.getKey();
                            if(name_to_search.equals(data)){
                                for(DataSnapshot sub_child: child.getChildren()){
                                    String data2 = (String) sub_child.getValue();
                                    to_display = "Name:"+child.getKey()+"\n"+sub_child.getKey()+":"+data2+"\n";
                                }
                            }display_details.setText(to_display);
                        }

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                }
        );
//        DataSnapshot dataSnapshot = new DataSnapshot(myurl, com.firebase.client.snapshot.IndexedNode);



    }

}
