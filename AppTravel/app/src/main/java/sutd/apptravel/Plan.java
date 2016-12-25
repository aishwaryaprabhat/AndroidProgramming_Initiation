package sutd.apptravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import static sutd.apptravel.Data.ENUM;
import static sutd.apptravel.Data.getResult;

public class Plan extends AppCompatActivity {

    EditText budget;
    ListView planlist;
    Button optimise;
    public static String item;
    public static List<String> attractionList = new ArrayList<>();
    public static ArrayAdapter<String> adapter;
    public static List<String> display = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        budget = (EditText) findViewById(R.id.budget);
        planlist = (ListView) findViewById(R.id.planlist);
        optimise = (Button) findViewById(R.id.optimise);

        optimise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (budget.getText().toString().equals("")|attractionList.size()==0){
                    Toast.makeText(Plan.this,"Please enter budget and choose attractions",Toast.LENGTH_SHORT).show();
                }
                else {
                    ENUM(attractionList, Double.parseDouble(budget.getText().toString()));
                    List<String> result = getResult();
                    for (String a: result){
                        display.add(a);
                    }
                    LayoutInflater layoutInflater
                            = (LayoutInflater)getBaseContext()
                            .getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.popup_result, null);
                    final PopupWindow popupWindow = new PopupWindow(
                            popupView,
                            LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT);

                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Plan.this, android.R.layout.simple_list_item_1,display);
                    ListView res = (ListView) popupView.findViewById(R.id.opt);
                    res.setAdapter(adapter2);

                    Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
                    btnDismiss.setOnClickListener(new Button.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });

                    popupWindow.showAsDropDown(planlist, 0, -1000);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,attractionList);
        planlist.setAdapter(adapter);

        List<String> categories = new ArrayList<>();
        categories.add("Marina Bay Sands");
        categories.add("Singapore Flyer");
        categories.add("Vivo City");
        categories.add("Resorts World Sentosa");
        categories.add("Buddha Relic Tooth");
        categories.add("Singapore Zoo");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void addOne (View v){
        addItems(item);
    }

    public static void addItems(String s) {
        attractionList.add(s);
        adapter.notifyDataSetChanged();
    }

    public void reset(View v){
        attractionList.clear();
        adapter.notifyDataSetChanged();
    }

    public void explore(View view){
        Intent intent = new Intent(this, Explore.class);
        startActivity(intent);
    }

    public void vlog(View view){
        Intent intent = new Intent (this, Vlog.class);
        startActivity(intent);
    }

}
