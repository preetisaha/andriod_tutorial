package com.android.tutorial.broadcast_tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StaticBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_POWER_CONNECTED)){
            System.out.println("========================= ACTION_POWER_CONNECTED =========================");
        }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
            System.out.println("========================= ACTION_POWER_DISCONNECTED =========================");
        }
    }
}
