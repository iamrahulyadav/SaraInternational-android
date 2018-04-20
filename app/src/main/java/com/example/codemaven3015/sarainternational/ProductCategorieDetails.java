package com.example.codemaven3015.sarainternational;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ProductCategorieDetails extends AppCompatActivity {
    GridView gridView;
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
        setGridData();

    }

    private void setGridData()
    {
        ProductGridView adapterViewAndroid = new ProductGridView(this, gridViewString, gridViewImageId,"cat");

        gridView.setAdapter(adapterViewAndroid);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                //Toast.makeText(this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
    }
}
