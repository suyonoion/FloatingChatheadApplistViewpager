package com.suyonoion.floatingchathead;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Suyono on 5/21/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
public class tampilkanViewPager extends LinearLayout {

    private PagerTitleStrip pagerTitleStrip;
    private MyAdapter adapter;
    private List<String> titlelist;
    private List<View> tampildaftarHalaman;
    private ViewPager viewpager;
    private View mHalamanSatu;
    private View mHalamanDua;
    private View mHalamanTiga;
    private View mHalamanEmpat;
    private View mHalamanLima;
    private View mHalamanEnam;
    private View mHalamanTujuh;
    private View mHalamanDelapan;
    private View mHalamanSembilan;
    private View mHalamanSepuluh;

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }


    public tampilkanViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(setResource("tempat_viewpager","layout"), this, true);

        viewpager = (ViewPager)root.findViewById(setResource("viewpager","id"));
        mHalamanSatu = inflater.inflate(getContext().getResources().getLayout(setResource("halaman1","layout")), null, true);
        mHalamanDua = inflater.inflate(getContext().getResources().getLayout(setResource("halaman2","layout")), null, true);
        mHalamanTiga = inflater.inflate(getContext().getResources().getLayout(setResource("halaman3","layout")), null, true);
        mHalamanEmpat = inflater.inflate(getContext().getResources().getLayout(setResource("halaman4","layout")), null, true);
        mHalamanLima = inflater.inflate(getContext().getResources().getLayout(setResource("halaman5","layout")), null, true);
        mHalamanEnam = inflater.inflate(getContext().getResources().getLayout(setResource("halaman6","layout")), null, true);
        mHalamanTujuh = inflater.inflate(getContext().getResources().getLayout(setResource("halaman7","layout")), null, true);
        mHalamanDelapan = inflater.inflate(getContext().getResources().getLayout(setResource("halaman8","layout")), null, true);
        mHalamanSembilan = inflater.inflate(getContext().getResources().getLayout(setResource("halaman9","layout")), null, true);
        mHalamanSepuluh = inflater.inflate(getContext().getResources().getLayout(setResource("halaman10","layout")), null, true);

        tampildaftarHalaman = new ArrayList<View>();
        tampildaftarHalaman.add(mHalamanSatu);
        tampildaftarHalaman.add(mHalamanDua);
        tampildaftarHalaman.add(mHalamanTiga);
        tampildaftarHalaman.add(mHalamanEmpat);
        tampildaftarHalaman.add(mHalamanLima);
        tampildaftarHalaman.add(mHalamanEnam);
        tampildaftarHalaman.add(mHalamanTujuh);
        tampildaftarHalaman.add(mHalamanDelapan);
        tampildaftarHalaman.add(mHalamanSembilan);
        tampildaftarHalaman.add(mHalamanSepuluh);

        pagerTitleStrip = (PagerTitleStrip) findViewById(setResource("pagertitle","id"));
        titlelist = new ArrayList<String>();
        titlelist.add(getResources().getString(setResource("tab_1","string")));
        titlelist.add(getResources().getString(setResource("tab_2","string")));
        titlelist.add(getResources().getString(setResource("tab_3","string")));
        titlelist.add(getResources().getString(setResource("tab_4","string")));
        titlelist.add(getResources().getString(setResource("tab_5","string")));
        titlelist.add(getResources().getString(setResource("tab_6","string")));
        titlelist.add(getResources().getString(setResource("tab_7","string")));
        titlelist.add(getResources().getString(setResource("tab_8","string")));
        titlelist.add(getResources().getString(setResource("tab_9","string")));
        titlelist.add(getResources().getString(setResource("tab_10","string")));

        adapter = new MyAdapter(titlelist, tampildaftarHalaman);
        viewpager.setPageTransformer(true, new CubeOutTransformer());
        viewpager.setAdapter(adapter);

    }

}
