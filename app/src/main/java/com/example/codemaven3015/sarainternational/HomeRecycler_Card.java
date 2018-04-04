package com.example.codemaven3015.sarainternational;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Admin on 3/28/2018.
 */

public class HomeRecycler_Card extends RecyclerView.Adapter<HomeRecycler_Card.ViewHolder> {

    private Context context;



    public HomeRecycler_Card(Context context) {
        this.context = context;

    }
    private int[] images = {
            R.drawable.poly,R.drawable.poly,R.drawable.poly,
            R.drawable.poly,R.drawable.poly,R.drawable.poly,
            R.drawable.poly,R.drawable.poly,R.drawable.poly};



    private String[] text = {"Paper Bag","Paper Bag","Paper Bag",
            "Paper Bag","Paper Bag","Paper Bag",
            "Paper Bag","Paper Bag","Paper Bag"};



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_card, null,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       viewHolder.card_img.setImageResource(images[i]);
        viewHolder. card_textview.setText(text[i]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;

        ImageView card_img;;
        TextView card_textview;


        public ViewHolder(View itemView) {
            super(itemView);
            card_img=itemView.findViewById(R.id.card_img);
            card_textview=itemView.findViewById(R.id.card_textview);
    }



    public void startDetailsActivity(){

    }

}}
