package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.ingichuk.app.seochon.R;
import com.ingichuk.app.seochon.SeochonApplication;
import com.ingichuk.app.seochon.adapters.DrawerAdapter;
import com.ingichuk.app.seochon.models.Point;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;


public class MapActivity extends FragmentActivity {

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private MapView mapView;
    private ListView drawerList;
    private DrawerAdapter drawerAdapter;

    private Intent intent;

    private final int[] pins = {
                                R.drawable.pin_food_c,
                                R.drawable.pin_cafe_c,
                                R.drawable.pin_event_c,
                                R.drawable.pin_park_c,
                                R.drawable.pin_view_c};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mapView = new MapView(this);
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
        drawerLayout.addView(mapView);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerList.setAdapter(drawerAdapter);
        drawerList.bringToFront();

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        intent = getIntent();
        initPoints(intent.getIntExtra("mode", 0));

        mapView.setDaumMapApiKey(SeochonApplication.getDaumMapApiKey());
        mapView.setMapType(MapView.MapType.Standard);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5787331, 126.9724879), false);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i < 5) {
                    initPoints(i);
                }
                drawerLayout.closeDrawer(Gravity.START);
            }
        });
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

    private void initPoints(int mode) {
        ArrayList<Point> points = new ArrayList<Point>();
        switch (mode) {
            case 0:
                points.add(new Point("코끼리가 먹었어", 37.5772803, 126.9681131));
                points.add(new Point("밥 플러스", 37.5806317, 126.9681516));
                points.add(new Point("비비큐 효자점", 37.5812977, 126.9689362));
                points.add(new Point("토속촌", 37.577994, 126.984747));
                points.add(new Point("남도분식", 37.5809522, 126.9668661));
                break;
            case 1:
                points.add(new Point("어게인", 37.5792255, 126.9717483));
                points.add(new Point("커피공방 BeanStore", 37.5792948, 126.9705269));
                points.add(new Point("제비다방", 37.5786238, 126.9708307));
                break;
            case 2:
                points.add(new Point("ayu", 37.5797484, 126.9697547));
                points.add(new Point("커피공방 앞 공연", 37.5796405, 126.971836));
                points.add(new Point("사직동그가게 옆 공터 공연", 37.5771229, 126.9677847));
                break;
            case 3:
                points.add(new Point("사직공원", 37.5794482, 126.9711691));
                points.add(new Point("수성동 계곡", 37.5826268, 126.9626783));
                points.add(new Point("북악산길 산책로", 37.5814517, 126.9757532));
                break;
            case 4:
                points.add(new Point("통인시장", 37.5808454, 126.9768424));
                points.add(new Point("금천교시장", 37.5795809, 126.9766723));
                points.add(new Point("통인어린이작은도서관", 37.5802504, 126.9711521));
                break;
        }
        setMapPoints(points, mode);
    }

    private void setMapPoints(ArrayList<Point> points, int mode) {
        mapView.removeAllPOIItems();
        for(Point point : points) {
            MapPOIItem poiItem = new MapPOIItem();
            poiItem.setItemName(point.getTitle());
            poiItem.setMapPoint(MapPoint.mapPointWithGeoCoord(point.getLatitude(), point.getLongitude()));
            poiItem.setMarkerType(MapPOIItem.MarkerType.CustomImage);
            poiItem.setShowAnimationType(MapPOIItem.ShowAnimationType.SpringFromGround);
            poiItem.setCustomImageResourceId(pins[mode]);
            poiItem.setCustomImageAnchorPointOffset(new MapPOIItem.ImageOffset(22, 0));
            mapView.addPOIItem(poiItem);
        }
        mapView.fitMapViewAreaToShowAllPOIItems();
    }
}