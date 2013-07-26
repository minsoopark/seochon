package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.ingichuk.app.seochon.R;
import com.ingichuk.app.seochon.SeochonApplication;
import com.ingichuk.app.seochon.adapters.DrawerAdapter;
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;


public class MapActivity extends NMapActivity implements NMapView.OnMapStateChangeListener{

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private DrawerAdapter drawerAdapter;

    private NMapView mapView;
    private NMapController mapController;

    private Intent intent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mapView = (NMapView) findViewById(R.id.map_view);
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

        mapView.setApiKey(SeochonApplication.getMapApiKey());
        mapController = mapView.getMapController();

        mapView.setBuiltInZoomControls(true, null);
        mapView.setOnMapStateChangeListener(this);
        mapView.setClickable(true);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceStage) {
        super.onPostCreate(savedInstanceStage);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
        if (nMapError == null) { // success
            mapController.setMapCenter(new NGeoPoint(126.9724879, 37.5787331), 13);
        } else { // fail
            Log.e("ERROR", "onMapInitHandler: error=" + nMapError.toString());
        }
    }

    @Override
    public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) { }

    @Override
    public void onMapCenterChangeFine(NMapView nMapView) { }

    @Override
    public void onZoomLevelChange(NMapView nMapView, int i) { }

    @Override
    public void onAnimationStateChange(NMapView nMapView, int i, int i2) { }

}