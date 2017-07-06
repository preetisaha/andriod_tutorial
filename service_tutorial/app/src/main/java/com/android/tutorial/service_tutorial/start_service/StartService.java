package com.android.tutorial.service_tutorial.start_service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

public class StartService extends Service {

    private final AtomicInteger count = new AtomicInteger();

    public StartService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra(StartServiceActivity.input1Key);
        String value = intent.getStringExtra(StartServiceActivity.input2Key);
        executeTask(input, value);
        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("======================================== OnCreate Start service method");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("======================================== OnDestroy Start service method");
    }

    public void executeTask(final String input, String valueStr) {
        final Integer value = Integer.parseInt(valueStr);
        count.incrementAndGet();
        new AsyncTask<String, Integer, Integer>() {

            @Override
            protected Integer doInBackground(String... strings) {

                for (int count = 0; count < value; count++) {
                    System.out.println(input + " ## value is - " + count);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                if (count.decrementAndGet() == 0)
//                    StartService.this.stopSelf();

                return null;
            }
        }.execute();
    }
}


















