package com.android.tutorial.service_tutorial.intent_service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public static final String messageAction = "com.android.tutorial.service_tutorial.intent_service.MESSAGE_ACTION";
    public static final String textAction = "com.android.tutorial.service_tutorial.intent_service.TEXT_ACTION";


    public MyIntentService() {
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(this.getClass().getName(), "============================= onCreate =============================");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(this.getClass().getName(), "============================= onDestroy =============================");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if(action.equals(messageAction)) {
            showMessage();
        }else if(action.equals(textAction)){
            showText();
        }
    }

    public void showMessage(){
        for(int count=0; count<10; count++){
            System.out.println("============================= showMessage " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showText(){
        for(int count=0; count<10; count++){
            System.out.println("============================= showText " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
