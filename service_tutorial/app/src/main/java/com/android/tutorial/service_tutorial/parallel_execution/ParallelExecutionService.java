package com.android.tutorial.service_tutorial.parallel_execution;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelExecutionService extends Service {

    private static final int notificationId= 111;
    private boolean checkStatus = false;
    private int totalTask = 0;
    private ExecutorService executorsService;

    public ParallelExecutionService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        executorsService = Executors.newCachedThreadPool();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        final String userInput = intent.getStringExtra(ParallelExecutionActivity.userInputKey);
        synchronized (this) {
            totalTask++;
            executeOnForeground();
        }
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                for(int count=0; count<10; count++){
                    System.out.println("Thread is running -" + count + " , " + " User input is - " + userInput);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (ParallelExecutionService.this) {
                    totalTask--;
                    if (totalTask == 0) {
                        executeOffForeground();
                    }
                }
            }
        };

        executorsService.execute(runnable);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void executeOnForeground(){
        if (!checkStatus) {
            Notification notification = new Notification();
            startForeground(notificationId, notification);
            checkStatus = true;
        }
    }

    public void executeOffForeground(){
        if (checkStatus){
            stopForeground(checkStatus);
            checkStatus = false;
        }
    }
}
