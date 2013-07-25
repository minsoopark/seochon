package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.ingichuk.app.seochon.R;

public class SplashActivity extends Activity {

    private SharedPreferences pref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences("pref", MODE_PRIVATE);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = null;
                if(pref.getBoolean("is_first", true)) {
                    intent = new Intent(SplashActivity.this, HowtouseActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };

        handler.postDelayed(runnable, 2500);
    }

    @Override
    public void onBackPressed() {

    }
}
