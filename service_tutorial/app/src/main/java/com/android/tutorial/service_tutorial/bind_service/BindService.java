package com.android.tutorial.service_tutorial.bind_service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.IBinder;
import java.util.Random;

public class BindService extends Service {

    private LocalBinder localBinder = new LocalBinder();
    private CallBack activity;

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class LocalBinder extends Binder{

        public BindService getService(){
            return BindService.this;
        }
    }

    public void setActivity(CallBack activity){
        this.activity = activity;
    }

    public interface CallBack{
        public void taskComplete(int value);
    }

    public void executeTask(){

        new AsyncTask<String, Integer, Integer>(){

            @Override
            protected Integer doInBackground(String... strings) {
                for(int count=0; count<20; count++){
                    System.out.println("Thread is running");
                }
                return (new Random()).nextInt();
            }

            @Override
            protected void onPostExecute(Integer integer) {
                activity.taskComplete((new Random()).nextInt());
            }
        }.execute("");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("======================================== OnCreate method");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("========================================= OnDestroy method");
    }
}
