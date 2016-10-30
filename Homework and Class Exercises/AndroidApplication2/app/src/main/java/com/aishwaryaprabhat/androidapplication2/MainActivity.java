package com.aishwaryaprabhat.androidapplication2;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
//    private static android.R.attr R;
    public static EditText password;
    public static TextView response;
//    public static String password_string;
//    public static boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.password);
        response = (TextView)findViewById(R.id.response);
        Button button =(Button)findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (passwordchecker(password.getText().toString())==true){
                            Toast.makeText(MainActivity.this,"Correct Password",Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );

    }
    public static boolean passwordchecker(String password_ud){
        System.out.println(password_ud);
        if (password_ud.equals("java")==true){
            return true;
        }else{return false;}
    }
}
