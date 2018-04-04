package com.example.codemaven3015.sarainternational;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Admin on 2/2/2018.
 */

class HomeImage__ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private int[] images={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4};



    public HomeImage__ViewPagerAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount(){
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view,Object object){
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container,final int Position){
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.CustomImage);
        imageView.setImageResource(images[Position]);
        ViewPager vp=(ViewPager)container;
        vp.addView(view,0);
        String flag = ((Activity) context).getIntent().getStringExtra("IN_VIEW_IMAGE");
        if(flag == null){
            flag = "";
        }
        if(flag.equals("true")){
            //imageView.setAdjustViewBounds(true);
            //imageView.setScaleType(ImageView.ScaleType.);
        }else {
            //imageView.setAdjustViewBounds(false);
            //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    moveToImageSiteView();
                }
            });
        }
        return view;

    }
    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
    public void moveToImageSiteView(){
        Intent i = new Intent(context,HomeContent.class);
        i.putExtra("IN_VIEW_IMAGE","true");
        context.startActivity(i);
    }
}
