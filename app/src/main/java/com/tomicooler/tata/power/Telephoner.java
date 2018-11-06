package com.tomicooler.tata.power;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

public class Telephoner {

    private final Context context;
    private final String number;

    public Telephoner(Context context, String number) {
        this.context = context;
        this.number = number;
    }

    public void startCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (ContextCompat.checkSelfPermission(context,
                android.Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            context.startActivity(intent);
        }
    }

}
