tATA Protector Power Detector
=============================

[tATA - the Anti Theft Auto](https://play.google.com/store/apps/details?id=com.tomicooler.tata.protector) is a simple car alarm
android application. It used to have a **"call at power connected/disconnected"** feature. Unfortunately on newer android versions (>26),
it is no longer possible to handle ACTION_POWER_CONNECTED and ACTION_POWER_DISCONNECTED events [implicit broadcast restrictions](https://developer.android.com/about/versions/oreo/background#broadcasts).

This is a simple android application where you can make phone calls on charging started, stopped events.
It targets android api 25 where it is still possible to listen for implicit broadcasts.
It cannot be published to play store anymore, but feel free to use it.

tATA is no longer available in Play Market
------------------------------------------

The official Play Market is getting stricter - which is a good thing - but unfortunately tATA had to be removed
from the Play Market. (SMS permissions)

I think getting the location via SMS was the most useful feature of this project, so I decided to remove the app
from the Play Market, however the latest binaries are available here.

What is tATA?
-------------

[![tATA video](https://img.youtube.com/vi/vHlMRs05CKg/0.jpg)](https://www.youtube.com/watch?v=vHlMRs05CKg)

^ check the video


Features:
- retrieve car location
- location based car theft detection
- spy on microphone
- low battery alert

Internet connection is optional, but I suggest to use it, because:
- depending on the usage, SMS may cost more
- GPS is much faster and more accurate with internet connection (a-gps)
- the debug mode is recommended, so you will learn how it works

Keep in mind that tATA is not a professional car alarm solution, USE IT AT YOUR OWN RISK. Be extremely careful with hiding mobile phone or power bank in your car, they can explode under extreme hot environment! I take no responsibility or liability for car thefts.

It is not an easy task to setup tATA Protector properly, so I recommend only for people who like hacking and patient enough. Check the Help screen in the application for guidance.

Security notes:
- SMS and GCM API is enabled by default
- change the default SMS password
- do NOT share your GCM ID
- tATA is "peer-to-peer", your personal data won't be stored in any tATA server, because there is no such thing

Tips & tricks:
- rooted phone can be automatically started on charge, google it :)
- https://github.com/tomicooler/htcdesire200autoboot

Privacy Policies:
- https://github.com/tomicooler/tATAPP


Downloads
---------

[Power Detector](https://github.com/tomicooler/tATAPowerDetector/raw/master/releases/power-detector-v1.apk)

[Protector](https://github.com/tomicooler/tATAPowerDetector/raw/master/releases/protector.apk)

[WatcherGCM](https://github.com/tomicooler/tATAPowerDetector/raw/master/releases/watchergcm.apk)

[WatcherSMS](https://github.com/tomicooler/tATAPowerDetector/raw/master/releases/watchersms.apk)

