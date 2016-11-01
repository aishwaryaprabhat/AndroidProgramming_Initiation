package com.aishwaryaprabhat.clientserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button server = (Button)findViewById(R.id.buttonClient);
        Button server2 = (Button)findViewById(R.id.buttonServer);
        server.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),CheckoffClientActivity.class);
                        startActivity(intent);
                    }
                }
        );
        server2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),CheckoffServerActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
