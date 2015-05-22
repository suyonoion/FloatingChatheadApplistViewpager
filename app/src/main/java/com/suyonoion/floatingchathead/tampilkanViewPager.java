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




    public tampilkanViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.tempat_viewpager, this, true);

        viewpager = (ViewPager)root.findViewById(R.id.viewpager);
        mHalamanSatu = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman1), null, true);
        mHalamanDua = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman2), null, true);
        mHalamanTiga = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman3), null, true);
        mHalamanEmpat = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman4), null, true);
        mHalamanLima = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman5), null, true);
        mHalamanEnam = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman6), null, true);
        mHalamanTujuh = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman7), null, true);
        mHalamanDelapan = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman8), null, true);
        mHalamanSembilan = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman9), null, true);
        mHalamanSepuluh = inflater.inflate(getContext().getResources().getLayout(R.layout.halaman10), null, true);

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

        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle);
        titlelist = new ArrayList<String>();
        titlelist.add(getResources().getString(R.string.tab_1));
        titlelist.add(getResources().getString(R.string.tab_2));
        titlelist.add(getResources().getString(R.string.tab_3));
        titlelist.add(getResources().getString(R.string.tab_4));
        titlelist.add(getResources().getString(R.string.tab_5));
        titlelist.add(getResources().getString(R.string.tab_6));
        titlelist.add(getResources().getString(R.string.tab_7));
        titlelist.add(getResources().getString(R.string.tab_8));
        titlelist.add(getResources().getString(R.string.tab_9));
        titlelist.add(getResources().getString(R.string.tab_10));

        adapter = new MyAdapter(titlelist, tampildaftarHalaman);
        viewpager.setPageTransformer(true, new CubeOutTransformer());
        viewpager.setAdapter(adapter);

    }

}
