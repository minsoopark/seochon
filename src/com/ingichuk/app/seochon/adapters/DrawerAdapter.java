package com.ingichuk.app.seochon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.ingichuk.app.seochon.R;


public class DrawerAdapter extends BaseAdapter {

    private Context context;

    public DrawerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = convertView;

        if(view == null) {
            view = li.inflate(R.layout.row_drawer, null);
        }

        ImageView drawerMenuItem = (ImageView) view.findViewById(R.id.drawer_menu_item);

        switch (position) {
            case 0:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_food);
                break;
            case 1:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_cafe);
                break;
            case 2:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_event);
                break;
            case 3:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_park);
                break;
            case 4:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_view);
                break;
            case 5:
                drawerMenuItem.setImageResource(R.drawable.mapmenu_button_setting);
                break;
        }

        return view;
    }
}
