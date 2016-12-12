package com.aishwaryaprabhat.gpsforparking;

import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.identity.intents.Address;
import android.location.Address;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    protected Location mLastLocation;
    private ResultReceiver mResultReceiver;
    private GoogleMap mMap;
    double lat;
    double longit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button search = (Button)findViewById(R.id.searchbutton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geolocate(view);
//                onMapReady(mMap);
            }
        });
    }
    public void geolocate(View v){

        final EditText searchlocation = (EditText)findViewById(R.id.locationsearched);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(searchlocation.getWindowToken(),0);
        String location = searchlocation.getText().toString();
        Geocoder gc = new Geocoder(this);

        Firebase myurl = new Firebase("https://gpsforparking.firebaseio.com/Destination");

        try {
            List<Address> list_of_location = gc.getFromLocationName(location, 1);
            Address add = list_of_location.get(0);
            String name = add.getLocality();
            lat = add.getLatitude();
            longit = add.getLongitude();


            myurl.child("Name").setValue(name);
            myurl.child("Longitude").setValue(longit);
            myurl.child("Latitude").setValue(lat);

            LatLng destination = new LatLng(lat, longit);
            mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));

        } catch (IOException e) {
            e.printStackTrace();
        }




        }







    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng destination = new LatLng(lat, longit);
        mMap.addMarker(new MarkerOptions().position(destination).title("Destination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(destination));
    }

}
