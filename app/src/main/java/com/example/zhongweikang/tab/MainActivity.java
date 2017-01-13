package com.example.zhongweikang.tab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.zhongweikang.tab.pagerAdapter.MyViewPagerAdapter;
import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    private LinearLayout Lone,Ltwo,Lthree,Lfour;
    private FrameLayout one,two,three,four;
    private   ArrayList<View> listFragment=new ArrayList<>();
    private MyViewPagerAdapter adapter;
    private ViewPager viewPager;
    private ImageView  home,user,set,fly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        adapter=new MyViewPagerAdapter(this,listFragment);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        slideViewPage();
    }

    private void slideViewPage() {
      viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    clearselected();
                    Selected(position);
          }

          @Override
          public void onPageSelected(int position) {

          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });
    }

    private void Selected(int i) {
        switch (i){
            case 0:
                home.setImageResource(R.drawable.homer);
                break;
            case 1:
                user.setImageResource(R.drawable.usering);
                break;
            case 2:
                fly.setImageResource(R.drawable.flayer);
                break;
            case 3:
                set.setImageResource(R.drawable.seted);
                break;
        }

    }

    private void initFragment() {
        listFragment.add(one);
        listFragment.add(two);
        listFragment.add(three);
        listFragment.add(four);
    }
    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        one= (FrameLayout) getLayoutInflater().inflate(R.layout.layout_01,null);
        two=(FrameLayout) getLayoutInflater().inflate(R.layout.layout_02,null);
        three=(FrameLayout) getLayoutInflater().inflate(R.layout.layout_03,null);
        four=(FrameLayout) getLayoutInflater().inflate(R.layout.layout_04,null);


        Lone= (LinearLayout) findViewById(R.id.one);
        Ltwo= (LinearLayout) findViewById(R.id.two);
        Lthree= (LinearLayout) findViewById(R.id.three);
        Lfour= (LinearLayout) findViewById(R.id.four);

        Lone.setOnClickListener(this);
        Ltwo.setOnClickListener(this);
        Lthree.setOnClickListener(this);
        Lfour.setOnClickListener(this);

        home= (ImageView) findViewById(R.id.home);
        user= (ImageView) findViewById(R.id.user);
        fly= (ImageView) findViewById(R.id.fly);
        set= (ImageView) findViewById(R.id.set);

    }
    @Override
    public void onClick(View v) {
        int i=0;
        clearselected();
        switch (v.getId()){
            case R.id.one:
                i=0;
                Selected(0);
               // home.setImageResource(R.drawable.homer);
                break;
            case R.id.two:
                i=1;
                Selected(1);
                //user.setImageResource(R.drawable.usering);
                break;
            case  R.id.three:
                i=2;
                Selected(2);
              //  fly.setImageResource(R.drawable.flayer);
                break;
            case  R.id.four:
                i=3;
                Selected(3);
               // set.setImageResource(R.drawable.seted);
                break;

        }
        viewPager.setCurrentItem(i);
    }

    private void clearselected() {
        home.setImageResource(R.drawable.home);
        user.setImageResource(R.drawable.mine);
        fly.setImageResource(R.drawable.fly);
        set.setImageResource(R.drawable.set);
    }


}


