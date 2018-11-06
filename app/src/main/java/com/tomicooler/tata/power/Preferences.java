package com.tomicooler.tata.power;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class Preferences {

    public static final String PROPERTY_PAIR_PHONE_NUMBER = "pair_phone_number";

    public static final String PROPERTY_POWER_CONNECTED = "power_connected";
    public static final String PROPERTY_POWER_DISCONNECTED = "power_disconnected";

    private final Context context;
    private final SharedPreferences preferences;

    public Preferences(Context context) {
        this.context = context;
        this.preferences = getPreferences();
    }

    public boolean isPowerConnectedEnabled() {
        return preferences.getBoolean(PROPERTY_POWER_CONNECTED, false);
    }

    public boolean isPowerDisconnectedEnabled() {
        return preferences.getBoolean(PROPERTY_POWER_DISCONNECTED, false);
    }

    public String getPairPhoneNumber() {
        return preferences.getString(PROPERTY_PAIR_PHONE_NUMBER, "");
    }

    private SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
