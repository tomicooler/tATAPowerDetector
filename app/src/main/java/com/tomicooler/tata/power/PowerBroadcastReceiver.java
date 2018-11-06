package com.tomicooler.tata.power;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;

public class PowerBroadcastReceiver extends WakefulBroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }

        Preferences preferences = new Preferences(context);

        if (action.equals(Intent.ACTION_POWER_CONNECTED) && !preferences.isPowerConnectedEnabled()) {
            return;
        }

        if (action.equals(Intent.ACTION_POWER_DISCONNECTED) && !preferences.isPowerDisconnectedEnabled()) {
            return;
        }

        ComponentName comp = new ComponentName(context.getPackageName(),
                PowerIntentService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
    }

    public static void enablePowerReceiver(Context context, boolean enable) {
        ComponentName receiver = new ComponentName(context, PowerBroadcastReceiver.class);
        PackageManager pm = context.getPackageManager();
        int enable_or_disable;

        if (enable) {
            enable_or_disable = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
        } else {
            enable_or_disable = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        }

        pm.setComponentEnabledSetting(receiver,
                enable_or_disable,
                PackageManager.DONT_KILL_APP);
    }
}
