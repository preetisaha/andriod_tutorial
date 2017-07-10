package com.android.tutorial.prefrence_tutorial;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends IntentService implements SharedPreferences.OnSharedPreferenceChangeListener{

    public MyService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        System.out.println("=================== Shared Preference Changed ================" + s + sharedPreferences.getString(s, "false"));
    }
}
