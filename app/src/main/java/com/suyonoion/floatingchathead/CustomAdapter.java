package com.suyonoion.floatingchathead;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter{

    private int resource;
    private LayoutInflater inflater;
    private Context context;

    public CustomAdapter ( Context ctx, int resourceId, List apps) {

        super( ctx, resourceId, apps );
        resource = resourceId;
        inflater = LayoutInflater.from( ctx );
        context=ctx;
    }

    @Override
    public View getView ( int position, View convertView, ViewGroup parent ) {
        convertView = (LinearLayout) inflater.inflate( resource, null );
        PInfo app = (PInfo) getItem(position);
        TextView txtName = (TextView) convertView.findViewById(R.id.app_name);
        txtName.setText(app.appname);
        ImageView imageCity = (ImageView) convertView.findViewById(R.id.app_icon);
        imageCity.setImageDrawable(app.icon);
        return convertView;
    }
}