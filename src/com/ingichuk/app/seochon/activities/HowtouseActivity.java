package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.ingichuk.app.seochon.R;


public class HowtouseActivity extends Activity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtouse);

//        TODO: 처음에만 실행되도록
//        pref = getSharedPreferences("pref", MODE_PRIVATE);
//        editor = pref.edit();
//        editor.putBoolean("is_first", false);
//        editor.commit();

        startActivity(new Intent(HowtouseActivity.this, MainActivity.class));
        finish();

    }
}