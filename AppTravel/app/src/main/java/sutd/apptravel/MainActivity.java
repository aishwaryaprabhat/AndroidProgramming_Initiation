package sutd.apptravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void explore(View view){
        Intent intent = new Intent (this, Explore.class);
        startActivity(intent);
    }

    public void plan(View view){
        Intent intent = new Intent (this, Plan.class);
        startActivity(intent);
    }
    public void vlog(View view){
        Intent intent = new Intent (this, Vlog.class);
        startActivity(intent);
    }
}
