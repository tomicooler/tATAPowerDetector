package com.tomicooler.tata.power;

import android.app.IntentService;
import android.content.Intent;

public class PowerIntentService extends IntentService {

    public PowerIntentService() {
        super("PowerIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Preferences preferences = new Preferences(getApplicationContext());
        Telephoner telephoner = new Telephoner(getApplicationContext(), preferences.getPairPhoneNumber());
        telephoner.startCall();

        PowerBroadcastReceiver.completeWakefulIntent(intent);
    }
}