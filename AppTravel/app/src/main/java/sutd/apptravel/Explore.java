package sutd.apptravel;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import static sutd.apptravel.TypoHandler.typoChecker;
import static sutd.apptravel.TypoHandler.getName;
import static sutd.apptravel.Plan.addItems;

public class Explore extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText location;
    Button list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        location = (EditText) findViewById(R.id.location);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        list = (Button) findViewById(R.id.list);

        list.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Explore.this, list);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        LatLng xy = typoChecker(item.getTitle().toString());
                        if (xy!=null) {
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xy, 16));
                            mMap.addMarker(new MarkerOptions().position(xy).title(TypoHandler.currentLoc));
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    public void search(View view) {
        String locationSearch = location.getText().toString();
        LatLng xy = typoChecker(locationSearch);
        if (xy == null) {
            Uri gmmIntentUri = Uri.parse("geo:1.3521,103.8198?q="+locationSearch);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        } else {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(xy, 16));
            mMap.addMarker(new MarkerOptions().position(xy).title(TypoHandler.currentLoc));
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    public void plan(View view){
        Intent intent = new Intent (this, Plan.class);
        startActivity(intent);
    }

    public void vlog(View view){
        Intent intent = new Intent (this, Vlog.class);
        startActivity(intent);
    }

    public void addToPlan(View view){
        String item = getName();
        addItems(item);
    }

}
