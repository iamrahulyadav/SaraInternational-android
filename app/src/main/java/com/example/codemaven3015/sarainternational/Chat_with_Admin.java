package com.example.codemaven3015.sarainternational;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Chat_with_Admin extends AppCompatActivity {
    android.support.v4.view.ViewPager ViewPager;
    LinearLayout SliderDots;
    private int dotsCount;
    private ImageView[]dots;
    ListView listMsg;
    ArrayList<Msg> listMessages;
    MessagesListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with__admin);
        ViewPager=findViewById(R.id.viewPagerImageDetails);
        SliderDots=findViewById(R.id.SliderDotes);
        ProductList__ViewPagerAdapter productDetailsViewPagerAdapter =new ProductList__ViewPagerAdapter(getApplicationContext());
        ViewPager.setAdapter(productDetailsViewPagerAdapter);
        dotsCount= productDetailsViewPagerAdapter.getCount();

        setViewPager();
        listMessages = new ArrayList<Msg>();
        listMessages.add(new Msg("cle","email","message","attach",true,"teleAttach","heure","date"));
        adapter = new MessagesListAdapter(this, listMessages);
        listMsg=findViewById(R.id.listView);
        listMsg.setAdapter(adapter);
    }

    private void setViewPager() {
        final ImageView[]dots = new ImageView[dotsCount];

        for(int i=0;i<dotsCount;i++){
            dots[i]=new ImageView(getApplicationContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot));
        ViewPager.addOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dot));

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

