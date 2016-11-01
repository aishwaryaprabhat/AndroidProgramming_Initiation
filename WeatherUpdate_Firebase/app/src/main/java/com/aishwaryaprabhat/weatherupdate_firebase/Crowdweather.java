package com.aishwaryaprabhat.weatherupdate_firebase;

import com.firebase.client.Firebase;

/**
 * Created by Lenovo on 10/31/2016.
 */
public class Crowdweather extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
