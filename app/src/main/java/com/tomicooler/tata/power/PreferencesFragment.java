package com.tomicooler.tata.power;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Patterns;


public class PreferencesFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private Context context;
    private Preferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        findPreference(Preferences.PROPERTY_PAIR_PHONE_NUMBER).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                return isValidPhoneNumber((String) newValue);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity().getApplicationContext();
        preferences = new Preferences(context);
        updatePhoneNumberSummary();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case Preferences.PROPERTY_PAIR_PHONE_NUMBER:
                updatePhoneNumberSummary();
                break;

            case Preferences.PROPERTY_POWER_CONNECTED:
            case Preferences.PROPERTY_POWER_DISCONNECTED:
                PowerBroadcastReceiver.enablePowerReceiver(context,
                        preferences.isPowerConnectedEnabled() || preferences.isPowerDisconnectedEnabled());
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

        @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

        public void disableCall() {
        findPreference(Preferences.PROPERTY_PAIR_PHONE_NUMBER).setEnabled(false);
        findPreference(Preferences.PROPERTY_POWER_CONNECTED).setEnabled(false);
        findPreference(Preferences.PROPERTY_POWER_DISCONNECTED).setEnabled(false);
    }

    private void updatePhoneNumberSummary() {
        String summary = preferences.getPairPhoneNumber();
        if (summary.isEmpty()) {
            summary = context.getString(R.string.preferences_summary_pair_phone_number);
        }
        EditTextPreference pref = (EditTextPreference) findPreference(Preferences.PROPERTY_PAIR_PHONE_NUMBER);
        pref.setSummary(summary);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.isEmpty() || Patterns.PHONE.matcher(phoneNumber).matches();
    }
}
