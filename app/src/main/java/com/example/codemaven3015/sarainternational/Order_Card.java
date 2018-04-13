package com.example.codemaven3015.sarainternational;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 3/28/2018.
 */

public class Order_Card extends RecyclerView.Adapter<Order_Card.ViewHolder> {

    private Context context;


    public Order_Card(Context context) {
        this.context = context;

    }
    private int[] images = {
            R.drawable.d1,R.drawable.poly,R.drawable.d3,
            R.drawable.d4,R.drawable.d3,R.drawable.poly,
            R.drawable.d3,R.drawable.d1,R.drawable.d4};


    private String[] product_name = {"Product Name",
            "Product Name","Product Name",
            "Product Name","Product Name",
            "Product Name","Product Name",
            "Product Name","Product Name"};

    private String[] status = {"Delivered on Wed,2oth Feb 2018",
            "Cancelled","Delivered on Wed,2oth Feb 2018",
            "Delivered on Wed,2oth Feb 2018","Cancelled",
            "Delivered on Wed,2oth Feb 2018","Delivered on Wed,2oth Feb 2018",
            "Cancelled","Delivered on Wed,2oth Feb 2018"};



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.order_deal_card, null,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       viewHolder.card_img.setImageResource(images[i]);
        viewHolder. status.setText(status[i]);
        viewHolder. product_name.setText(product_name[i]);
        viewHolder.circularTextView.setSolidColor("#5064a5");

    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;

        ImageView card_img;;
        TextView status,product_name;
        CircularTextView circularTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            card_img=itemView.findViewById(R.id.card_img);
            status=itemView.findViewById(R.id.status);
            product_name=itemView.findViewById(R.id.product_name);
            circularTextView=itemView.findViewById(R.id.circularTextView);
    }



    public void startDetailsActivity(){

    }

}}
