package com.example.codemaven3015.sarainternational;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductCategorieDetails extends AppCompatActivity {
    GridView gridView;
    ImageView cartImg;
    Button sort_textView;
    String[] gridViewString = {"PRODUCT NAME", "PRODUCT NAME", "PRODUCT NAME",
            "PRODUCT NAME", "PRODUCT NAME", "PRODUCT NAME"} ;
    int[] gridViewImageId = {
            R.drawable.d4, R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d1
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_categorie_details);
        gridView=findViewById(R.id.gridView);
        cartImg=findViewById(R.id.cartImg);
        setGridData();
        setOnClickSort();


    }

    private void setOnClickSort() {
        sort_textView = findViewById(R.id.sort_textView);
        sort_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShortDialogue();
            }
        });
    }
    public void showShortDialogue(){
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sort, null);
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        final AlertDialog dialog = alertDialogBuilder.create();
        ListView listView = view.findViewById(R.id.sortByList);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Prices - Low to High");
        list.add("Prices - High to Low");
        list.add("Popularity");
        list.add("Discount");
        list.add("Whats's New");
        list.add("Delivery Time");
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(itemsAdapter);
        dialog.show();


    }

    private void setGridData()
    {
        ProductGridView adapterViewAndroid = new ProductGridView(this, gridViewString, gridViewImageId,"cat");

        gridView.setAdapter(adapterViewAndroid);
    }
}
