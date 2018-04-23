package com.example.codemaven3015.sarainternational;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class ProductCategorieDetails extends AppCompatActivity {
    GridView gridView;
    ImageView cartImg;
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
        //cartImg.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
           //     setcartImg();
            //}
        //});
        setGridData();

    }

   // private void setcartImg()
    {
        //Intent i = new Intent(ProductCategorieDetails.this,Car.class);
        //startActivity(i);
    }

    private void setGridData()
    {
        ProductGridView adapterViewAndroid = new ProductGridView(this, gridViewString, gridViewImageId,"cat");

        gridView.setAdapter(adapterViewAndroid);
    }
}
