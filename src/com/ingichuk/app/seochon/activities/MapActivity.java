package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;
import com.ingichuk.app.seochon.R;
import com.ingichuk.app.seochon.adapters.DrawerAdapter;


public class MapActivity extends FragmentActivity {

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private DrawerAdapter drawerAdapter;

    private Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.drawer_list);
        drawerAdapter = new DrawerAdapter(this);
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.drawable.actionbar_button,
                R.string.open,
                R.string.close) {

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerList.setAdapter(drawerAdapter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        intent = getIntent();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceStage) {
        super.onPostCreate(savedInstanceStage);
        drawerToggle.syncState();
    }
}