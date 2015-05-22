package com.suyonoion.floatingchathead;

/**
 * Created by Suyono on 4/15/2015.
 */
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

public class MyAdapter extends PagerAdapter {
private List<View> list;
private List<String> titlelist;

    public MyAdapter(List<String> titlelist, List<View> list) {
 this.titlelist = titlelist;
      this.list = list;
         }
      //Here for the current page title card
             @Override
     public CharSequence getPageTitle(int position) {
              return titlelist.get(position);
         }
       @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(list.get(position));
            return list.get(position);
        }
        //The destruction of page card
        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(list.get(position));
        }
        //Get all the pages card number
        @Override
        public int getCount() {
            return list.size();
        }
        //To judge whether the currently displayed page card matching
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

    }
