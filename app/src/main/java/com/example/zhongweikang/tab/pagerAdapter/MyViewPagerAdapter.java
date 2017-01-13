package com.example.zhongweikang.tab.pagerAdapter;


import android.content.Context;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by zhongweikang on 2017/1/13.
 */

public class MyViewPagerAdapter extends PagerAdapter {
      private  Context context;
      private  ArrayList<View> list;

    public  MyViewPagerAdapter(Context context, ArrayList<View> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

      container.addView(list.get(position));

        return list.get(position) ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

       container.removeView(list.get(position));
    }
}
