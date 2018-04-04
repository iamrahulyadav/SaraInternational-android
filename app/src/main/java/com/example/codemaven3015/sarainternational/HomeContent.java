package com.example.codemaven3015.sarainternational;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Admin on 4/4/2018.
 */

public class HomeContent extends android.support.v4.app.Fragment  {
ViewPager ViewPager;
LinearLayout SliderDots;

    RecyclerView Popular_Product;
    LinearLayoutManager layoutManager;

    HomeRecycler_Card adapter;

    private int dotsCount;
    private ImageView[]dots;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.home,container,false);
        Popular_Product=view.findViewById(R.id.Popular_Product);
        ViewPager=view.findViewById(R.id.viewPagerImageDetails);
        SliderDots=view.findViewById(R.id.SliderDotes);
        HomeImage__ViewPagerAdapter productDetailsViewPagerAdapter =new HomeImage__ViewPagerAdapter(getContext());
        ViewPager.setAdapter(productDetailsViewPagerAdapter);
        dotsCount= productDetailsViewPagerAdapter.getCount();
        Popular_Product = view.findViewById(R.id.Popular_Product);
        setViewPager();
        setPopularProduct();
        return view;
    }

    private void setPopularProduct()
    {


        Popular_Product.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Popular_Product.setLayoutManager(layoutManager);
        adapter=new HomeRecycler_Card(getContext());
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        Popular_Product.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        Popular_Product.setItemAnimator(new DefaultItemAnimator());
        Popular_Product.setAdapter(adapter);
    }

    private void setViewPager() {
        final ImageView[]dots = new ImageView[dotsCount];

        for(int i=0;i<dotsCount;i++){
            dots[i]=new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.dot));
        ViewPager.addOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.dot));

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(), 4000 ,4000);
    }
    public class myTimerTask extends TimerTask {
        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(ViewPager.getCurrentItem() == 0){
                        ViewPager.setCurrentItem(1);
                    } else if(ViewPager.getCurrentItem() == 1){
                        ViewPager.setCurrentItem(2);
                    } else
                    {
                        ViewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }


}

