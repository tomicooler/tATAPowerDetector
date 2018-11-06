package com.tomicooler.tata.power;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

public class MainActivity extends Activity {

    private final static int MY_PERMISSION_REQUEST = 14;

    PreferencesFragment preferencesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            preferencesFragment = new PreferencesFragment();
            getFragmentManager().beginTransaction().add(R.id.fragment_container, preferencesFragment).commit();
        }

        requestDangerousPermissions();
    }

    private void requestDangerousPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},
                MY_PERMISSION_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST: {
                if (preferencesFragment != null) {
                    for (int i = 0; i < permissions.length; ++i) {
                        if (permissions[i].equals(Manifest.permission.CALL_PHONE) &&
                                grantResults[i] == PackageManager.PERMISSION_DENIED) {
                            preferencesFragment.disableCall();
                        }
                    }
                }
            }
        }
    }
}
