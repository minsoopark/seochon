package com.ingichuk.app.seochon;

import android.app.Application;
import android.os.Build;
import android.provider.Settings;
import com.ingichuk.app.seochon.R;
import com.pushlink.android.PushLink;

public class SeochonApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PushLink.addMetadata("Phone", Build.DEVICE);
        PushLink.start(this, R.drawable.ic_launcher,
                "2165mbuqr499kk9o",
                Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID));
    }
}
