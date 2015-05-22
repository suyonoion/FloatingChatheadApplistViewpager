package com.suyonoion.floatingchathead;

/**
 * Created by Suyono on 5/22/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */
import android.support.v4.view.ViewPager;
import android.view.View;

public class CubeOutTransformer implements ViewPager.PageTransformer
{
    @Override
    public void transformPage(View page, float position) {
        page.setPivotX(position < 0f ? page.getWidth() : 0f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(90f * position);
    }
    public boolean isPagingEnabled()
    {
        return true;
    }
}

