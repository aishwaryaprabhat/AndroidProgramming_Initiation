package com.aishwaryaprabhat.javainterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Creating Layout
        RelativeLayout aishLayout = new RelativeLayout(this);
        aishLayout.setBackgroundColor(Color.RED);

        //Creating Button
        Button redButton = new Button(this);
        redButton.setText("Log In");
        redButton.setBackgroundColor(Color.BLUE);

        //User input
        EditText username = new EditText(this);

        redButton.setId(1);
        username.setId(2);

        //Button Rules
        RelativeLayout.LayoutParams buttonRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );
        buttonRules.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonRules.addRule(RelativeLayout.CENTER_VERTICAL);

        //Converting DIP to pixels
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());
        username.setWidth(px);

        //Username rules
        RelativeLayout.LayoutParams UserNameRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT );
        buttonRules.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonRules.addRule(RelativeLayout.CENTER_VERTICAL);
        UserNameRules.addRule(RelativeLayout.ABOVE, redButton.getId());
        UserNameRules.addRule(RelativeLayout.CENTER_HORIZONTAL);
        UserNameRules.setMargins(0,0,0,50);

        //Adding button to Layout
        aishLayout.addView(redButton, buttonRules);

        //Adding UserName field
        aishLayout.addView(username,UserNameRules);

        //Set this activity's content/display to this view
        setContentView(aishLayout);

    }
}
