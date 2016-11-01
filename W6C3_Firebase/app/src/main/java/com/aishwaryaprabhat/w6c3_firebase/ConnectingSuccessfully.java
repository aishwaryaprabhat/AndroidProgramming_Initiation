package com.aishwaryaprabhat.w6c3_firebase;

import com.firebase.client.Firebase;

/**
 * Created by Lenovo on 10/31/2016.
 */
public class ConnectingSuccessfully extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
