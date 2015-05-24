package com.suyonoion.floatingchathead;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Suyono on 5/21/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class tampilkanActivity extends LinearLayout {
    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }
    public tampilkanActivity(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(setResource("aktivity_utama","layout"), this, true);

// Mulai jika diklik
        Button launch = (Button) root.findViewById(setResource("button1","id"));
        launch.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FloatingchatheadAppList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().startService(intent);
            }
        });
        Button launch1 = (Button) root.findViewById(setResource("buttonB","id"));
        launch1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FloatingchatheadViewPager.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().startService(intent);
            }
        });
// Berhenti service
        Button stop = (Button) findViewById(setResource("button2","id"));
        stop.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FloatingchatheadAppList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().stopService(intent);
            }
        });
        Button stopB = (Button) root.findViewById(setResource("buttonB2","id"));
        stopB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FloatingchatheadViewPager.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().stopService(intent);
            }
        });

// Download project
        ImageView github = (ImageView) root.findViewById(setResource("imageView1","id"));
        github.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://github.com/suyonoion/FloatingChatheadApplistViewpager";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);
            }
        });
// Konfigurasi
        Button config = (Button) root.findViewById(setResource("button_config","id"));
        config.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getContext(), Configurations.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().startActivity(intent);
                getContext().stopService(new Intent(getContext(), FloatingchatheadAppList.class));
            }
        });
        Button configB = (Button) root.findViewById(setResource("button_configB","id"));
        configB.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getContext(), ConfigurationsB.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                getContext().startActivity(intent);
                getContext().stopService(new Intent(getContext(), FloatingchatheadViewPager.class));
            }
        });
    }

}
