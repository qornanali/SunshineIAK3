package com.example.sunshineiak3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by qornanali on 5/14/17.
 */

public class TodayReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Ini todayreceiver", Toast.LENGTH_SHORT).show();

        Intent todayIntent = new Intent(context, TodayService.class);
        context.startService(todayIntent);
    }
}
