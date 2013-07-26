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
                getPushLinkApiKey(),
                Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID));
    }

    public static String getMapApiKey() {
        return "742e652562bb34fcec507e0dd4885f76";
    }

    public static String getPushLinkApiKey() {
        return "2165mbuqr499kk9o";
    }
}
