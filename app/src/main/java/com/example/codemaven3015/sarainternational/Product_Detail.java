package com.example.codemaven3015.sarainternational;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by Admin on 4/4/2018.
 */

public class Product_Detail extends android.support.v4.app.Fragment {
    GridView gridView;
    String[] gridViewString = {"PRODUCT NAME", "PRODUCT NAME", "PRODUCT NAME",
            "PRODUCT NAME", "PRODUCT NAME", "PRODUCT NAME"} ;
    int[] gridViewImageId = {
            R.drawable.d4, R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d1
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.product,container,false);
        gridView=view.findViewById(R.id.gridView);
        setGridData();
              return view;
    }
    private void setGridData()
    {
       ProductGridView adapterViewAndroid = new ProductGridView(getContext(), gridViewString, gridViewImageId);

        gridView.setAdapter(adapterViewAndroid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(getContext(), "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
    }
}
