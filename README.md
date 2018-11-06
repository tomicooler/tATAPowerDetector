tATA Protector Power Detector
=============================

[tATA - the Anti Theft Auto](https://play.google.com/store/apps/details?id=com.tomicooler.tata.protector) is a simple car alarm
android application. It used to have a **"call at power connected/disconnected"** feature. Unfortunately on newer android versions (>26),
it is no longer possible to handle ACTION_POWER_CONNECTED and ACTION_POWER_DISCONNECTED events [implicit broadcast restrictions](https://developer.android.com/about/versions/oreo/background#broadcasts).

This is a simple android application where you can make phone calls on charging started, stopped events.
It targets android api 25 where it is still possible to listen for implicit broadcasts.
It cannot be published to play store anymore, but feel free to use it.

Releases
--------

[APK](https://github.com/tomicooler/tATAPowerDetector/raw/master/releases/power-detector-v1.apk)

