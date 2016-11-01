package com.aishwaryaprabhat.w6hwsp;

import com.firebase.client.Firebase;

/**
 * Created by Lenovo on 10/31/2016.
 */
public class StudentParticulars extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
