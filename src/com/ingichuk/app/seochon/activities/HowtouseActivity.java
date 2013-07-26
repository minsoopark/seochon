package com.ingichuk.app.seochon.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ingichuk.app.seochon.R;


public class HowtouseActivity extends Activity {

    private ViewPager viewPager;
    private HowtousePagerAdapter pagerAdapter;

    private View indicatorFirst;
    private View indicatorSecond;
    private View indicatorThird;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtouse);

        viewPager = (ViewPager) findViewById(R.id.how_to_use_pager);
        pagerAdapter = new HowtousePagerAdapter(this);

        indicatorFirst = findViewById(R.id.indicator_first);
        indicatorSecond = findViewById(R.id.indicator_second);
        indicatorThird = findViewById(R.id.indicator_third);

        viewPager.setAdapter(pagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {}

            @Override
            public void onPageSelected(int i) {
                indicatorFirst.setBackgroundResource(R.drawable.indicator_unselected);
                indicatorSecond.setBackgroundResource(R.drawable.indicator_unselected);
                indicatorThird.setBackgroundResource(R.drawable.indicator_unselected);

                switch(i) {
                    case 0:
                        indicatorFirst.setBackgroundResource(R.drawable.indicator_selected);
                        break;
                    case 1:
                        indicatorSecond.setBackgroundResource(R.drawable.indicator_selected);
                        break;
                    case 2:
                        indicatorThird.setBackgroundResource(R.drawable.indicator_selected);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });

//        TODO: 처음에만 실행되도록
//        pref = getSharedPreferences("pref", MODE_PRIVATE);
//        editor = pref.edit();
//        editor.putBoolean("is_first", false);
//        editor.commit();

        startActivity(new Intent(HowtouseActivity.this, MainActivity.class));
        finish();

    }

    private class HowtousePagerAdapter extends PagerAdapter {

        private LayoutInflater inflater;

        public HowtousePagerAdapter(Context context) {
            super();
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup pager, int position) {
            View v = null;
            if (position == 0) {
                v = inflater.inflate(R.layout.page_one, null);
            } else if (position == 1) {
                v = inflater.inflate(R.layout.page_two, null);
            } else {
                v = inflater.inflate(R.layout.page_three, null);
            }

            ((ViewPager) pager).addView(v, 0);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup pager, int position, Object view) {
            ((ViewPager) pager).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(ViewGroup arg0) {
        }

        @Override
        public void finishUpdate(ViewGroup arg0) {
        }
    }
}