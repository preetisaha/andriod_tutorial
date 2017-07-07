package com.android.tutorial.service_tutorial.foreground;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;

import com.android.tutorial.service_tutorial.R;

public class ForegroundService extends Service {
    private static final int NOTIFICATION_ID = 10;

    public ForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        NotificationManager mNotificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        // The id of the channel.
//        String id = "my_channel_01";
//        // The user-visible name of the channel.
//        CharSequence name = id;
//        // The user-visible description of the channel.
//        String description = id;
//        int importance = NotificationManager.IMPORTANCE_LOW;
//        NotificationChannel mChannel = new NotificationChannel(id, name, importance);
//        // Configure the notification channel.
//        mChannel.setDescription(description);
//        mChannel.enableLights(true);
//        // Sets the notification light color for notifications posted to this
//        // channel, if the device supports this feature.
//        mChannel.setLightColor(Color.RED);
//        mChannel.enableVibration(true);
//        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
//        mNotificationManager.createNotificationChannel(mChannel);
//
//        Notification.Builder b=new Notification.Builder(this);
//
//        b.setOngoing(true)
//                .setContentTitle("My Music")
//                .setContentText("Music")
//                .setSmallIcon(android.R.drawable.stat_sys_download)
//                .setTicker("dowload...")
//                .setChannelId(id);
//
//        // Start the service in the foreground
//        startForeground(NOTIFICATION_ID, b.build());
        return START_NOT_STICKY;
    }


}
