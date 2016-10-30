package com.aishwaryaprabhat.checkoff3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        final EditText to = (EditText)findViewById(R.id.to);
        final EditText CC = (EditText)findViewById(R.id.cc);
        final EditText subject = (EditText)findViewById(R.id.subject);
        final EditText email_body = (EditText)findViewById(R.id.message);
        Button send_buttonn = (Button)findViewById(R.id.send_button);
        send_buttonn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL,to.getText().toString());
                        intent.putExtra(Intent.EXTRA_CC,CC.getText().toString());
                        intent.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
                        intent.putExtra(Intent.EXTRA_TEXT,email_body.getText().toString());
                        intent.setType("message/rfc822");

                    }
                }

        );

    }
}
