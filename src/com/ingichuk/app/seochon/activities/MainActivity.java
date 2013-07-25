package com.ingichuk.app.seochon.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.ingichuk.app.seochon.R;


public class MainActivity extends Activity {

    private ImageView buttonMenuEat;
    private ImageView buttonMenuDrink;
    private ImageView buttonMenuPlay;
    private ImageView buttonMenuRest;
    private ImageView buttonMenuView;

    private View.OnClickListener menuClickListener;

    private Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMenuEat = (ImageView) findViewById(R.id.menu_eat);
        buttonMenuDrink = (ImageView) findViewById(R.id.menu_drink);
        buttonMenuPlay = (ImageView) findViewById(R.id.menu_play);
        buttonMenuRest = (ImageView) findViewById(R.id.menu_rest);
        buttonMenuView = (ImageView) findViewById(R.id.menu_view);


        menuClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                intent = new Intent(MainActivity.this, MapActivity.class);
                intent.putExtra("mode", tag);
                startActivity(intent);
            }
        };


        buttonMenuEat.setOnClickListener(menuClickListener);
        buttonMenuDrink.setOnClickListener(menuClickListener);
        buttonMenuPlay.setOnClickListener(menuClickListener);
        buttonMenuRest.setOnClickListener(menuClickListener);
        buttonMenuView.setOnClickListener(menuClickListener);
    }
}