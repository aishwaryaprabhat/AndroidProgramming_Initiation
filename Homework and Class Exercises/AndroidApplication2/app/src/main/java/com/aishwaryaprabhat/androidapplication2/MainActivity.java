package com.aishwaryaprabhat.androidapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static EditText password;
    public static TextView response;
    public static String password_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.password);
        response = (TextView)findViewById(R.id.response);
        Button button =(Button)findViewById(R.id.button);
        password_string = password.getText().toString();
        System.out.print("Hello");
        System.out.println(password_string);
        final String actual = "java";
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (password_string.equals(actual)){
                            response.setText("Correct Password");
                            System.out.println(password_string);
                        }else{
                            response.setText("Correct Password");
                            System.out.println(password_string);
                        }
                    }
                }
        );

    }
}
