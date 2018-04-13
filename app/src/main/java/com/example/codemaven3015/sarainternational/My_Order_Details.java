package com.example.codemaven3015.sarainternational;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class My_Order_Details extends AppCompatActivity {
RecyclerView RecyclerView;
    LinearLayoutManager layoutManager;

    Order_Card adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__order__details);
        RecyclerView=findViewById(R.id.RecyclerView);
        setOder();
    }
    private void setOder()
    {


        RecyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerView.setLayoutManager(layoutManager);
        adapter=new Order_Card(this);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        RecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        RecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.setAdapter(adapter);
    }
}
