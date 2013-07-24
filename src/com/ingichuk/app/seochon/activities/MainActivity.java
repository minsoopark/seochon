package com.ingichuk.app.seochon.activities;

import android.app.ActionBar;
import android.app.Activity;
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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMenuEat = (ImageView) findViewById(R.id.menu_eat);
        buttonMenuDrink = (ImageView) findViewById(R.id.menu_drink);
        buttonMenuPlay = (ImageView) findViewById(R.id.menu_play);
        buttonMenuRest = (ImageView) findViewById(R.id.menu_rest);
        buttonMenuView = (ImageView) findViewById(R.id.menu_view);


        buttonMenuEat.setOnClickListener(menuClickListener);
        buttonMenuDrink.setOnClickListener(menuClickListener);
        buttonMenuPlay.setOnClickListener(menuClickListener);
        buttonMenuRest.setOnClickListener(menuClickListener);
        buttonMenuView.setOnClickListener(menuClickListener);

        menuClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt((String)v.getTag());
                switch (tag) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        };
    }
}